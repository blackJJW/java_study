package nestedClassAndNestedInterface;

public class Outter {

	String field = "Outter - field";
	
	void method() {
		System.out.println("Outter - method");
	}
	
	class Nested{
		String field = "Nested - field";
		void method() {
			System.out.println("Nested - method");
		}
		
		void print() {
			System.out.println(this.field); // ÁßÃ¸ °´Ã¼ ÂüÁ¶
			this.method();
			System.out.println(Outter.this.field); // ¹Ù±ù °´Ã¼ ÂüÁ¶
			Outter.this.method();
		}
	}
}
