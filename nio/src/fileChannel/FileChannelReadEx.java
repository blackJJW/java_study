package fileChannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelReadEx {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("C:/Temp/file.txt");
		
		// FileChannel 생성
		FileChannel fileChannel = FileChannel.open(
				path, 
				StandardOpenOption.READ
				);
		
		ByteBuffer byteBuffer = ByteBuffer.allocate(100);
		
		Charset charset = Charset.defaultCharset();
		String data = "";
		int byteCount;
		
		while(true) {
			// 파일로부터 데이터 읽기
			byteCount = fileChannel.read(byteBuffer);
			if(byteCount == -1) break;
			byteBuffer.flip();
			data += charset.decode(byteBuffer).toString();
			byteBuffer.clear();
		}
		
		fileChannel.close();
		System.out.println("file.txt : " + data);
	}
}
