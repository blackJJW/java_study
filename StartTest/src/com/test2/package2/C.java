package com.test2.package2; // ��Ű���� �ٸ�

import com.test2.package1.A;

public class C {
	public C() {
		A a = new A();
		a.field1 = 1; // (o)
		a.field2 = 1; // (x) default ���� ����(������ ����)
		a.field3 = 1; // (x) private ���� ����(������ ����)
		
		a.method1(); // (o)
		a.method2(); // (x)  default ���� ����(������ ����)
		a.method3(); // (x)  private ���� ����(������ ����)
	}

}
