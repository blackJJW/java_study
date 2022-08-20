package nestedClassAndNestedInterface;

public class Annonymous {

	// �ʵ� �ʱⰪ���� ����
	RemoteControl field = new RemoteControl() { // �ʵ� ����� �ʱⰪ ����
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
		// ���� ���������� ����
		RemoteControl localVar = new RemoteControl() { // ���� ���� ����� �ʱⰪ ����
			@Override
			public void turnOn() {
				System.out.println("Audio On");
			}
			@Override
			public void turnOff() {
				System.out.println("Audio Off");
			}
		};
		// ���� ���� ���
		localVar.turnOn();
	}
	void method2(RemoteControl rc) {
		rc.turnOn();
	}
}
