package inheritance;

public class ChildEx {

	public static void main(String[] args) {
		Child child = new Child();
		
		Parent parent = child; // 자동타입변화
		parent.method1();
		parent.method2(); // 재정의된 메소드가 호출됨
		//parent.method3();
	}

}
