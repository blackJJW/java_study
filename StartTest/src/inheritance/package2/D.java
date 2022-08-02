package inheritance.package2;

import inheritance.package1.A;

public class D extends A{
	public D() {
		super();              // (o)
		this.field = "value"; // (o)
		this.method();        // (o)
	}
}
