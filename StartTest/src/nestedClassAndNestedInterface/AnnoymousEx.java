package nestedClassAndNestedInterface;

public class AnnoymousEx {

	public static void main(String[] args) {
		Annonymous annony = new Annonymous();
		// �͸� ��ü �ʵ� ���
		annony.field.turnOn();
		// �͸� ��ü ���� ���� ���
		annony.method1();
		// �͸� ��ü �Ű��� ���
		annony.method2(
				new RemoteControl() {  // �Ű���
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
