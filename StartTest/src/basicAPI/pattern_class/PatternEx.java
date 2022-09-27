package basicAPI.pattern_class;

import java.util.regex.Pattern;

public class PatternEx {

	public static void main(String[] args) {
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		String data = "010-123-4567";
		boolean result = Pattern.matches(regExp, data);
		
		if(result) {
			System.out.println("정규식과 일치");
		} else {
			System.out.println("정규식과 불일치");
		}
		
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = "abc@abcde.com";
		result = Pattern.matches(regExp, data);
		
		if(result) {
			System.out.println("정규식과 일치");
		} else {
			System.out.println("정규식과 불일치");
		}

	}

}
