package basicAPI.objectClass;

public class Member2Ex {

	public static void main(String[] args) {
		// 원본 객체 생성
		Member2 original = new Member2("ABC", 23, new int[] {90, 90}, new Car("그랜져"));
		
		// 깊은 복제 후 참조 객체의 데이터를 변경
		// 복제 객체를 얻은 후에 참조 객체의 데이터를 변경
		Member2 cloned = original.getMember2();
		cloned.scores[0] = 100;
		cloned.car.model = "소나타";
		
		System.out.println("[ 복제 객체의 필드값 ]");
		System.out.println("name : " + cloned.name);
		System.out.println("age : " + cloned.age);
		System.out.print("scores : {");
		for(int i = 0; i < cloned.scores.length; i++) {
			System.out.print(cloned.scores[i]);
			System.out.print((i == (cloned.scores.length - 1)) ? "" : ",");
		}
		System.out.println("}");
		System.out.println("car : " + cloned.car.model);
		
		System.out.println();
		
		System.out.println("[ 원본 객체의 필드값 ]");
		System.out.println("name : " + original.name);
		System.out.println("age : " + original.age);
		System.out.print("scores : {");
		for(int i = 0; i < original.scores.length; i++) {
			System.out.print(original.scores[i]);
			System.out.print((i==(original.scores.length - 1)) ? "" : ",");
		}
		System.out.println("}");
		System.out.println("car : " + original.car.model);

	}

}
