
public class AccuracyEx {

	public static void main(String[] args) {
		int apple = 1;
		double pieceUnit = 0.1;
		int number = 7;
		
		double result = apple - number * pieceUnit;
		
		System.out.printf("사과 %d개에서\n", apple);
		System.out.printf("%.1f 조각을 빼면,\n", number * pieceUnit);
		System.out.println(result + "조각이 남는다.");

	}

}
