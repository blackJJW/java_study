package inheritance;

public class ATire extends Tire{
	// �ʵ�
	// ������
	public ATire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	// �޼ҵ�
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + "ATire ���� : " 
		                       + (maxRotation - accumulatedRotation) 
		                       + " ȸ");
			return true;
		} else {
			System.out.println("*** " + location + " ATire ��ũ ***");
			return false;
		}
	}
}
