package collectionFramework;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashtableEx {

	public static void main(String[] args) {
		Map<String, String> map = new Hashtable<String, String>();
		
		// 아이디와 비밀번호를 미리 저장
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		
		// 키보드로부터 입력된 내용을 받기 위해 생성
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("아이디와 비밀번호를 입력");
			System.out.print("아이디 : ");
			
			// 키보드로 입력한 아이디를 읽는다.
			String id = scanner.nextLine();
			System.out.println();
			
			System.out.print("비밀번호 : ");
			
			// 키보드로 입력한 비밀번호를 읽는다.
			String password = scanner.nextLine();
			System.out.println();
			
			if(map.containsKey(id)) { // 아이디인 키가 존재하는지 확인
				if(map.get(id).equals(password)) { // 비밀번호를 비교
					System.out.println("로그인 됨");
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않음");
				}
			} else {
				System.out.println("입력한 아이디가 존재하지 않음");
			}
		}
	}
}
