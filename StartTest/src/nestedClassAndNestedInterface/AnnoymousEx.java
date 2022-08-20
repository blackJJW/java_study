package nestedClassAndNestedInterface;

public class AnnoymousEx {

	public static void main(String[] args) {
		Annonymous annony = new Annonymous();
		// 익명 객체 필드 사용
		annony.field.turnOn();
		// 익명 객체 로컬 변수 사용
		annony.method1();
		// 익명 객체 매개값 사용
		annony.method2(
				new RemoteControl() {  // 매개값
					@Override
					public void turnOn() {
						System.out.println("Smart TV On");
					}
					@Override
					public void turnOff() {
						System.out.println("Smart TV Off");
					}
				}
		);
	}

}
