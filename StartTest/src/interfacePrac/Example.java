package interfacePrac;

public class Example {

	public static void main(String[] args) {
		ImplementsC impl = new ImplementsC();
		
		InterfaceA ia = impl;
		ia.methodA();
		System.out.println(); // InterfaceA 변수는 methodA()만 호출 가능
		
		InterfaceB ib = impl;
		ib.methodB();
		System.out.println(); // InterfaceB 변수는 methodB()만 호출 가능
		
		InterfaceC ic = impl;
		ic.methodA(); // InterfaceA 변수는 methodA(),
		ic.methodB(); // methodB(),
		ic.methodC(); // methodC() 모두 호출 가능
		

	}

}
