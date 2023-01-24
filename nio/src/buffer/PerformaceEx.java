package buffer;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class PerformaceEx {

	public static void main(String[] args) throws Exception {
		Path from = Paths.get("src/buffer/p-1.png");
		Path to1 = Paths.get("src/buffer/p-2.png");
		Path to2 = Paths.get("src/buffer/p-3.png");
		
		long size = Files.size(from);
		
		FileChannel fileChannel_from = FileChannel.open(from);
		FileChannel fileChannel_to1 = FileChannel.open(to1,
				EnumSet.of(StandardOpenOption.CREATE,
						StandardOpenOption.WRITE));
		FileChannel fileChannel_to2 = FileChannel.open(to2,
				EnumSet.of(StandardOpenOption.CREATE,
						StandardOpenOption.WRITE));
		
		// 다이렉트와 넌다이렉트 버퍼 생성
		ByteBuffer nonDirectBuffer = ByteBuffer.allocate((int) size);
		ByteBuffer directBuffer = ByteBuffer.allocateDirect((int) size);
		
		long start, end;
		
		// 넌다이렉트 버퍼 테스트
		start = System.nanoTime();
		for(int i = 0; i < 100; i++) {
			fileChannel_from.read(nonDirectBuffer);
			nonDirectBuffer.flip();
			fileChannel_to1.write(nonDirectBuffer);
			nonDirectBuffer.clear();
		}
		end = System.nanoTime();
		System.out.println("non-Direct : \t" + (end - start) + " ns");
		
		// 파일의 위치를 0으로 설정(처음으로 돌림)
		fileChannel_from.position(0);
		
		// 다이렉트 버퍼 테스트
		start = System.nanoTime();
		for(int i = 0; i < 100; i++) {
			fileChannel_from.read(directBuffer);
			nonDirectBuffer.flip();
			fileChannel_to1.write(directBuffer);
			nonDirectBuffer.clear();
		}
		end = System.nanoTime();
		System.out.println("Direct : \t" + (end - start) + " ns");
		
		fileChannel_from.close();
		fileChannel_to1.close();
		fileChannel_to2.close();
	}
}
