package com.test2.package1;// ��Ű���� ����

public class B {
	public B() {
		A a = new A();
		a.field1 = 1; // (o)
		a.field2 = 1; // (o)
		a.field3 = 1; // (x) private ���� ����(������ ����)
		
		a.method1(); // (o)
		a.method2(); // (o)
		a.method3(); // (x)  private ���� ����(������ ����)
	}
}
