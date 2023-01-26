package buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferEx {

	public static void main(String[] args) {
		System.out.println("[ 7바이트 크기로 버퍼 생성 ]");
		
		// 다이렉트 버퍼 생성
		ByteBuffer buffer = ByteBuffer.allocate(7);
		printState(buffer);
		
		// 상대적 저장
		buffer.put((byte) 10);
		buffer.put((byte) 11);
		System.out.println("[ 2바이트 저장후 ]");
		printState(buffer);
		
		// 상대적 저장
		buffer.put((byte) 12);
		buffer.put((byte) 13);
		buffer.put((byte) 14);
		System.out.println("[ 3바이트 저장후 ]");
		printState(buffer);
		
		// 데이터를 읽기 위해 위치 속성값 변경
		buffer.flip();
		System.out.println("[ flip() 실행 후 ]");
		printState(buffer);
		
		// 상대적 읽기
		buffer.get(new byte[3]);
		System.out.println("[ 3바이트 읽은 후 ]");
		printState(buffer);
		
		// 마크하기
		buffer.mark();
		System.out.println("-----[ 현재 위치를 마크 해놓음 ]");
		
		// 상대적 읽기
		buffer.get(new byte[2]);
		System.out.println("[ 2바이트 읽은 후 ]");
		printState(buffer);
		
		// 마크 위치로 position 이동
		buffer.reset();
		System.out.println("-----[ position을 마크 위치로 옮김 ]");
		printState(buffer);
		
		// position을 0으로 이동
		buffer.rewind();
		System.out.println("[ rewind() 실행후 ]");
		printState(buffer);
		
		// 모든 위치 속성값을 초기화
		buffer.clear();
		System.out.println("[ clear() 실행 후 ]");
		printState(buffer);

	}
	
	public static void printState(Buffer buffer) {
		System.out.print("\tposition : " + buffer.position() + ", ");
		System.out.print("\tlimt : " + buffer.limit() + ", ");
		System.out.println("\tcapacity : " + buffer.capacity());
	}

}
