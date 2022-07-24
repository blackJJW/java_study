package classEx;

public class Calculator4Ex {

	public static void main(String[] args) {
		Calculator4 myCal = new Calculator4();
		
		double result1 = 10 * 10 * myCal.pi;
		int result2 = myCal.plus(10, 5);
		int result3 = myCal.minus(10, 5);
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);

	}

}
