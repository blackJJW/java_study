package inputOutput.console;

import java.io.Console;

public class ConsoleEx {

	public static void main(String[] args) {
		Console console = System.console();
		
		System.out.print("아이디 : ");
		String id = console.readLine();
		
		System.out.print("패스워드 : ");
		char[] charPass = console.readPassword();
		
		// char[] 배열을 문자열로 생성
		String strPassword = new String(charPass);
		
		System.out.println("---------------------");
		
		// id와 Password를 콘솔에 출력
		System.out.println(id);
		System.out.println(strPassword);
	}

}
