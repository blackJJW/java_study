package interfacePrac;

public class Example {

	public static void main(String[] args) {
		ImplementsC impl = new ImplementsC();
		
		InterfaceA ia = impl;
		ia.methodA();
		System.out.println(); // InterfaceA ������ methodA()�� ȣ�� ����
		
		InterfaceB ib = impl;
		ib.methodB();
		System.out.println(); // InterfaceB ������ methodB()�� ȣ�� ����
		
		InterfaceC ic = impl;
		ic.methodA(); // InterfaceA ������ methodA(),
		ic.methodB(); // methodB(),
		ic.methodC(); // methodC() ��� ȣ�� ����
		

	}

}
