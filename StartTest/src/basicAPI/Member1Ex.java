package basicAPI;

public class Member1Ex {

	public static void main(String[] args) {
		// 원본 객체 생성
		Member1 original = new Member1("blue", "ABC", "12345", 25, true);
		
		// 복제 객체를 얻은 후에 패스워드 변경
		Member1 cloned = original.getMember1();
		cloned.password = "67890"; // 복제 객체에서 password 변경
		
		System.out.println("[ 복제 객체의 필드값 ]");
		System.out.println("id : " + cloned.id);
		System.out.println("name : " + cloned.name);
		System.out.println("password : " + cloned.password);
		System.out.println("age : " + cloned.age);
		System.out.println("adult : " + cloned.adult);
		
		System.out.println();
		
		System.out.println("[ 원본 객체의 필드값 ]");
		System.out.println("id : " + original.id);
		System.out.println("name : " + original.name);
		System.out.println("password : " + original.password);
		System.out.println("age : " + original.age);
		System.out.println("adult : " + original.adult);

	}

}
