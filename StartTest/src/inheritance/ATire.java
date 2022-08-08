package inheritance;

public class ATire extends Tire{
	// 필드
	// 생성자
	public ATire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	// 메소드
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + "ATire 수명 : " 
		                       + (maxRotation - accumulatedRotation) 
		                       + " 회");
			return true;
		} else {
			System.out.println("*** " + location + " ATire 펑크 ***");
			return false;
		}
	}
}
