package interfacePrac;

public class Audio implements RemoteControl{

	// �ʵ�
	private int volume;
	private boolean mute;
	
	// turnOn() �߻� �޼ҵ��� ��ü �޼ҵ�
	public void turnOn() {
		System.out.println("Audio ON");
	}
		
	// turnOff() �߻� �޼ҵ��� ��ü �޼ҵ�
	public void turnOff() {
		System.out.println("Audio OFF");
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
		System.out.println("���� Audio ���� : " + this.volume);
	}
	
	@Override
	public void setMute(boolean mute) { // ����Ʈ �޼ҵ� ������
		this.mute = mute;
		if(mute) {
			System.out.println("Audio ���� ó��");
		} else {
			System.out.println("Audio ���� ����");
		}
	}
}
