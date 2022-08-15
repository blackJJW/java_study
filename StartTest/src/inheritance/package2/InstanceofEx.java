package inheritance.package2;

public class InstanceofEx {
	public static void method1(Parent parent) {
		if(parent instanceof Child) {	// Child Ÿ������ ��ȯ�� �������� Ȯ��
			Child child = (Child) parent;
			System.out.println("method1 - Child�� ��ȯ ����");
		} else {
			System.out.println("method1 - Child�� ��ȯ���� ����");
		}
	}
	
	public static void method2(Parent parent) {
		Child child = (Child) parent;	// ClassCastException �߻� ����
		System.out.println("method2 - Child�� ��ȯ ����");
	}
	
	public static void main(String[] args) {
		Parent parentA = new Child();
		method1(parentA);	// Child ��ü�� 
		method2(parentA);	// �Ű������� ����
		
		Parent parentB = new Parent();
		method1(parentB);				// Parent ��ü��
		method2(parentB);	// ���� �߻�   // �Ű������� ���� 
	}

}