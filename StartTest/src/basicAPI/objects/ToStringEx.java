package basicAPI.objects;

import java.util.Objects;

public class ToStringEx {

	public static void main(String[] args) {
		String str1 = "ABC";
		String str2 = null;
		
		System.out.println(Objects.toString(str1));
		System.out.println(Objects.toString(str2));
		System.out.println(Objects.toString(str2, "이름이 없음"));

	}

}
