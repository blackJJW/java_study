package buffer;

import java.nio.ByteBuffer;

public class BufferSizeEx {

	public static void main(String[] args) {
		ByteBuffer directBuffer = ByteBuffer.allocateDirect(200 * 1024 * 1024);
		System.out.println("다이렉트 버퍼가 생성됨");
		
		ByteBuffer nonDirectBuffer = ByteBuffer.allocate(200 * 1024 * 1024);
		System.out.println("넌다이렉트 버퍼가 생성됨");
	}
}
