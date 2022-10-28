package generic;

public class CompareMethodEx {

	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "apple");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "apple");
		boolean result1 = Util.<Integer, String>compare(p1, p2);
		                     // 구체적 타입을 명시적으로 지정
		
		if(result1) {
			System.out.println("논리적으로 동등한 객체");
		} else {
			System.out.println("논리적으로 동등하지 않은 객체");
		}
		
		Pair<String, String> p3 = new Pair<String, String>("user1", "ABC");
		Pair<String, String> p4 = new Pair<String, String>("user2", "ABC");
		boolean result2 = Util.compare(p3, p4);
		                    // 구체적 타입을 추정
		
		if(result2) {
			System.out.println("논리적으로 동등한 객체");
		} else {
			System.out.println("논리적으로 동등하지 않은 객체");
		}
	}

}
