package nestedClassAndNestedInterface;

public class AnonymousEx {

	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		
		// 익명 객체 필드 사용
		anony.field.wake();
		
		// 익명 객체 로컬 변수 사용
		anony.method1();
		
		// 익명 객체 매객값 사용
		anony.method2(
				new Person() { // 매개값
					void study() {
						System.out.println("공부");
					}
					@Override
					void wake() {
						System.out.println("8시에 일어남");
						study();					}
				}
			);
	}

}
