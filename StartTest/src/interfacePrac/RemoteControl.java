package interfacePrac;

public interface RemoteControl {
	
	// ���
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	
	// �߻� �޼ҵ�           // �޼ҵ� ����θ� �ۼ�
	public void turnOn(); 
	public void turnOff();
	public void setVolume(int volume);
	
	// ����Ʈ �޼ҵ�
	default void setMute(boolean mute) { // ���� ������� �ۼ�
		if(mute) {
			System.out.println("mute ON");
		} else {
			System.out.println("mute OFF");
		}
	}
	
	// ���� �޼ҵ�
	static void changeBattery() {
		System.out.println("������ ��ȯ");
	}
}
