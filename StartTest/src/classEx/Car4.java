package classEx;

public class Car4 {
	// �ʵ�
	int gas;
	
	// ������
	
	// �޼ҵ�
	void setGas(int gas) {
		this.gas = gas;
	} // ���ϰ��� ���� �޼ҵ�� �Ű����� �޾Ƽ� gas �ʵ尪�� ����
	
	boolean isLeftGas() {
		/* ���ϰ��� boolean�� �޼ҵ�� 
		 * gas �ʵ尪��
		 * 0�̸� false�� 
		 * 0�� �ƴϸ� true�� ���� */
		if(gas == 0) {
			System.out.println("gas�� �����ϴ�.");
			return false; // false�� ����
		}
		System.out.println("gas�� �ֽ��ϴ�.");
		return true; // true�� ����
	}
	
	void run() {
		/* ���ϰ��� ���� �޼ҵ��
		 * gas �ʵ尪�� 0�̸�
		 * return������ �޼ҵ带 ���� ����*/
		while(true) {
			if(gas > 0) {
				System.out.println("�޸��ϴ�.(gas�ܷ� : " + gas + ")");
				gas -= 1;
			} else {
				System.out.println("����ϴ�.(gas�ܷ� : " + gas + ")");
				return; // �޼ҵ� ���� ����
			}
		}
	}
}
