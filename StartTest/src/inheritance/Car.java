package inheritance;

public class Car {
	// �ʵ�
	Tire[] tires = {
			new Tire("�� ����", 6),
			new Tire("�� ������", 2),
			new Tire("�� ����", 3),
			new Tire("�� ������", 4)
	};
	
	// �޼ҵ�
	int run() {
		System.out.println("�ڵ����� �޸���.");
		for(int i = 0; i < tires.length; i++) {
			if(tires[i].roll() == false) {
				stop();
				return (i + 1);
			}
		}
		return 0;
	}
	
	void stop() {
		System.out.println("�ڵ����� ����ϴ�.");
	}
}
