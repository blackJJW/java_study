package inheritance;

public abstract class Phone {

	// �ʵ�
	public String owner;
	
	// ������
	public Phone(String owner) {
		this.owner = owner;
	}
	
	// �޼ҵ�
	public void turnOn() {
		System.out.println("�� ���� ON");
	}
	public void turnOff() {
		System.out.println("�� ���� OFF");
	}
}
