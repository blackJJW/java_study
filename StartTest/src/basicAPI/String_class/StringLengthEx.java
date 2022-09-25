package basicAPI.String_class;

public class StringLengthEx {

	public static void main(String[] args) {
		String ssn = "9201231234567";
		
		int length = ssn.length();
		if(length == 13) {
			System.out.println("주민번호 자리수 맞음");
		} else {
			System.out.println("주민번호 자리수 틀림");
		}
	}
}
