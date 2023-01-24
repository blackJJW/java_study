package buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

public class DirectBufferCapacityEx {

	public static void main(String[] args) {
		// 100개의 byte값 저장
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
		System.out.println("저장용랼 : " + byteBuffer.capacity() + " 바이트");
		
		// 50개의 char값 저장
		CharBuffer charBuffer 
				= ByteBuffer.allocateDirect(100).asCharBuffer();
		System.out.println("저장용랼 : " + charBuffer.capacity() + " 문자");
		
		// 25개의 int값 저장
		IntBuffer intBuffer
				= ByteBuffer.allocateDirect(100).asIntBuffer();
		System.out.println("저장용랼 : " + intBuffer.capacity() + " 정수");
	}
}
