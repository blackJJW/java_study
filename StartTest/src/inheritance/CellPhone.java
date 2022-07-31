package inheritance;

public class CellPhone {
	// 필드
	String model;
	String color;
	
	// 생성자
	
	// 메소드
	void powerOn() { System.out.println("power on"); }
	void powerOff() { System.out.println("power off"); }
	void bell() { System.out.println("벨이 울립니다."); }
	void sendVoice(String message) { System.out.println("나 : " + message); }
	void receiveVoice(String message) {System.out.println("상대방 : " + message); }
	void hangUp() { System.out.println("전화를 끊습니다."); }
	
}
