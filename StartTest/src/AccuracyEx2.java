
public class AccuracyEx2 {

	public static void main(String[] args) {
		int apple = 1;
		
		int totalPieces = apple * 10;
		int number = 7;
		int temp = totalPieces - number;
		
		double result = temp / 10.0;
		
		System.out.printf("사과 %d개에서\n", apple);
		System.out.printf("%.1f 조각을 빼면,\n", number / 10.0);
		System.out.println(result + " 조각이 남는다.");

	}

}
