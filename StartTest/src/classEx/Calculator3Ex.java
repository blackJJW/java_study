package classEx;

public class Calculator3Ex {

	public static void main(String[] args) {
		Calculator3 myCalc = new Calculator3();
		
		// ���簢�� ����
		double result1 = myCalc.areaRectangle(10);
		
		// ���簢�� ����
		double result2 = myCalc.areRectangle(10, 20);
		
		System.out.println("���簢�� ���� : " + result1);
		System.out.println("���簢�� ���� : " + result2);

	}

}
