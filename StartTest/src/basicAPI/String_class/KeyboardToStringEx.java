package basicAPI.String_class;

import java.io.IOException;

public class KeyboardToStringEx {

	public static void main(String[] args) throws IOException{
		// 읽은 바이트를 저장하기 위한 배열 생성
		byte[] bytes = new byte[10];
		
		System.out.println("input : ");
		
		//배열에 읽은 바이트를 저장하고 읽은 바이트수를 리턴
		int readByteNo = System.in.read(bytes);
		
		// 배열을 문자열로 변환
		String str = new String(bytes, 0, readByteNo - 2);
                                   // 2를 뺀 이유 : \r + \n 부분은
		                           // 문자열로 만들 필요가 없기 때문
		System.out.println(str);
	}

}
