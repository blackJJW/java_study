package inheritance;

public class DmbCellPhoneEx {

	public static void main(String[] args) {
		// DmbCellPhone 객체 생성
		DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);
		
		// CellPhone으로부터 상속받은 필드
		System.out.println("model : " + dmbCellPhone.model);
		System.out.println("color : " + dmbCellPhone.color);
		
		// DmbCellPhone의 필드
		System.out.println("channel : " + dmbCellPhone.channel);
		
		// CellPhone으로부터 상속받은 메소드 호출
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요.");
		dmbCellPhone.receiveVoice("안녕하세요!");
		dmbCellPhone.sendVoice("아 예~~");
		dmbCellPhone.hangUp();
		
		// DmbCellPhone의 메소드 호출
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(7);
		dmbCellPhone.turnOffDmb();
	}

}
