package fileChannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileCopyEx {

	public static void main(String[] args) throws IOException {
		Path from = Paths.get("src/fileChannel/p-1.png");
		Path to = Paths.get("src/fileChannel/p-2.png");
		
		// 읽기 FileChannel 생성
		FileChannel fileChannel_from = FileChannel.open(
			from, StandardOpenOption.READ);
		
		// 쓰기 FileChannel 생성
		FileChannel fileChannel_to = FileChannel.open(
				to, StandardOpenOption.CREATE, 
				StandardOpenOption.WRITE);
		
		ByteBuffer buffer = ByteBuffer.allocateDirect(100);
		int byteCount;
		while(true) {
			buffer.clear();
			byteCount = fileChannel_from.read(buffer); // 읽기
			if(byteCount == -1) break;
			buffer.flip();
			fileChannel_to.write(buffer); // 쓰기
		}
		
		fileChannel_from.close();
		fileChannel_to.close();
		System.out.println("파일 복사 성공");
	}
}
