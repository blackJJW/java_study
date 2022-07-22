package classEx;

public class KoreanEx {

	public static void main(String[] args) {
		Korean k1 = new Korean("자바", "981023-1234567");
		System.out.println("k1.name : " + k1.name);
		System.out.println("k1.ssn : " + k1.ssn);
		
		Korean k2 = new Korean("파이썬", "950912-2345678");
		System.out.println("k2.name : " + k2.name);
		System.out.println("k2.ssn : " + k2.ssn);

	}

}
