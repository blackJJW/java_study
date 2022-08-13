package interfacePrac;

public class Television implements RemoteControl{

	// �ʵ�
	private int volume;
	
	// turnOn() �߻� �޼ҵ��� ��ü �޼ҵ�
	public void turnOn() {
		System.out.println("TV ON");
	}
	
	// turnOff() �߻� �޼ҵ��� ��ü �޼ҵ�
	public void turnOff() {
		System.out.println("TV OFF");
	}
	
	// setVolume() �߻� �޼ҵ��� ��ü �޼ҵ�
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) { // �������̽� ����� �̿��ؼ�
			this.volume = RemoteControl.MAX_VOLUME; // volume �ʵ��� ���� ����
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("���� TV ���� : " + this.volume);
	}
}
