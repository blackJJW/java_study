package inheritance;

public class ChildEx {

	public static void main(String[] args) {
		Child child = new Child();
		
		Parent parent = child; // �ڵ�Ÿ�Ժ�ȭ
		parent.method1();
		parent.method2(); // �����ǵ� �޼ҵ尡 ȣ���
		//parent.method3();
	}

}
