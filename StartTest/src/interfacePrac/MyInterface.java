package interfacePrac;

public interface MyInterface {

	public void method1();
	
	public default void method2() { // ����Ʈ �޼ҵ�
		System.out.println("MyInterface - method2 ����");
	}
}
