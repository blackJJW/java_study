
public class InputDataCheckEx {

	public static void main(String[] args) {
		String userInput = "NaN"; 
		
		double val = Double.valueOf(userInput); 
		
		double currentBalance = 10000.0;
		
		if (Double.isNaN(val)) { // NaN을 검사
			System.out.println("NaN이 입력되어 연산 불가");
			val = 0.0;
		}
		
		currentBalance += val; // currentBalance 값이 유지 
		System.out.println(currentBalance);

	}

}
