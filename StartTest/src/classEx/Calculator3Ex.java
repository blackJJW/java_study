package classEx;

public class Calculator3Ex {

	public static void main(String[] args) {
		Calculator3 myCalc = new Calculator3();
		
		// 정사각형 넓이
		double result1 = myCalc.areaRectangle(10);
		
		// 직사각형 넓이
		double result2 = myCalc.areRectangle(10, 20);
		
		System.out.println("정사각형 넓이 : " + result1);
		System.out.println("직사각형 넓이 : " + result2);

	}

}
