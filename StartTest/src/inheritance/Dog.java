package inheritance;

public class Dog extends Animal{

	public Dog() {
		this.kind = "포유류";
	}
	
	@Override
	public void sound() { // 추상 메소드 오버라이딩
		System.out.println("멍멍");
	}
}
