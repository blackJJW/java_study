package inheritance;

public class BTire extends Tire{
		// 필드
		// 생성자
		public BTire(String location, int maxRotation) {
			super(location, maxRotation);
		}
		
		// 메소드
		@Override
		public boolean roll() {
			++accumulatedRotation;
			if(accumulatedRotation < maxRotation) {
				System.out.println(location + "BTire 수명 : " 
			                       + (maxRotation - accumulatedRotation) 
			                       + " 회");
				return true;
			} else {
				System.out.println("*** " + location + " BTire 펑크 ***");
				return false;
			}
		}
}
