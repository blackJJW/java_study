package interfacePrac;

public class Audio implements RemoteControl{

	// 필드
	private int volume;
	private boolean mute;
	
	// turnOn() 추상 메소드의 실체 메소드
	public void turnOn() {
		System.out.println("Audio ON");
	}
		
	// turnOff() 추상 메소드의 실체 메소드
	public void turnOff() {
		System.out.println("Audio OFF");
	}
		
	// setVolume() 추상 메소드의 실체 메소드
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) { // 인터페이스 상수를 이용해서
			this.volume = RemoteControl.MAX_VOLUME; // volume 필드의 값을 제한
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 Audio 볼륨 : " + this.volume);
	}
	
	@Override
	public void setMute(boolean mute) { // 디폴트 메소드 재정의
		this.mute = mute;
		if(mute) {
			System.out.println("Audio 무음 처리");
		} else {
			System.out.println("Audio 무음 해제");
		}
	}
}
