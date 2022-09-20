package basicAPI.objects;

import java.util.Objects;

public class NullEx {

	public static void main(String[] args) {
		String str1 = "ABC";
		String str2 = null;
		
		System.out.println(Objects.requireNonNull(str1));
		
		try {
			String name = Objects.requireNonNull(str2);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String name = Objects.requireNonNull(str2, "이름 없음");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String name = Objects.requireNonNull(str2, ()->"이름 없습니다.");
			                                          // 람다식 
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
