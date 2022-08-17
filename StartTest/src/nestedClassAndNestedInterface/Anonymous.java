package nestedClassAndNestedInterface;

public class Anonymous {

	// 필드 초기값으로 대입
	Person field = new Person() { // 필드 선언돠 초기값 대입
		void work() {
			System.out.println("출근");
		}
		@Override
		void wake() {
			System.out.println("6시에 일어남");
			work();
		}
	};
	
	void method1() {
		// 로컬 변수값으로 대입
		Person localVar = new Person() { // 로컬 변수 선언과 초기값 대입
			void walk() {
				System.out.println("산책");
			}
			@Override
			void wake() {
				System.out.println("7시에 일어남");
				walk();
			}
		};
		// 로컬 변수 사용
		localVar.wake();
	}
	
	void method2(Person person) {
		person.wake();
	}
}
