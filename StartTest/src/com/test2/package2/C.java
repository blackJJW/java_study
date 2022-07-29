package com.test2.package2; // 패키지가 다름

import com.test2.package1.A;

public class C {
	public C() {
		A a = new A();
		a.field1 = 1; // (o)
		a.field2 = 1; // (x) default 접근 제한(컴파일 에러)
		a.field3 = 1; // (x) private 접근 제한(컴파일 에러)
		
		a.method1(); // (o)
		a.method2(); // (x)  default 접근 제한(컴파일 에러)
		a.method3(); // (x)  private 접근 제한(컴파일 에러)
	}

}
