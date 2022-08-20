package nestedClassAndNestedInterface;

public class Annonymous {

	// 필드 초기값으로 대입
	RemoteControl field = new RemoteControl() { // 필드 선언과 초기값 대입
		@Override
		public void turnOn() {
			System.out.println("TV On");
		}
		@Override
		public void turnOff() {
			System.out.println("TV Off");
		}
	};
	
	void method1() {
		// 로컬 변수값으로 대입
		RemoteControl localVar = new RemoteControl() { // 로컬 병수 선언과 초기값 대입
			@Override
			public void turnOn() {
				System.out.println("Audio On");
			}
			@Override
			public void turnOff() {
				System.out.println("Audio Off");
			}
		};
		// 로컬 변수 사용
		localVar.turnOn();
	}
	void method2(RemoteControl rc) {
		rc.turnOn();
	}
}
