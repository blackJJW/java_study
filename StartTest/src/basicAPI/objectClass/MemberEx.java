package basicAPI.objectClass;

public class MemberEx {

	public static void main(String[] args) {
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");
		
		if(obj1.equals(obj2)) { // 매개값이 Member 타입이고 id 필드값도 동일하므로 true
			System.out.println("obj1과 obj2는 동등");
		} else {
			System.out.println("obj1과 obj2는 다름");
		}
		
		if(obj1.equals(obj3)) { // 매개값이 Member 타입이지만 id 필드값이 다르므로 false
			System.out.println("obj1과 obj3은 동일");
		} else {
			System.out.println("obj1과 obj3은 다름");
		}

	}

}
