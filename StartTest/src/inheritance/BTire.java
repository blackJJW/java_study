package inheritance;

public class BTire extends Tire{
		// �ʵ�
		// ������
		public BTire(String location, int maxRotation) {
			super(location, maxRotation);
		}
		
		// �޼ҵ�
		@Override
		public boolean roll() {
			++accumulatedRotation;
			if(accumulatedRotation < maxRotation) {
				System.out.println(location + "BTire ���� : " 
			                       + (maxRotation - accumulatedRotation) 
			                       + " ȸ");
				return true;
			} else {
				System.out.println("*** " + location + " BTire ��ũ ***");
				return false;
			}
		}
}
