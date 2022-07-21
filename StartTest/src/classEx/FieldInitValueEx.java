package classEx;

public class FieldInitValueEx {

	public static void main(String[] args) {
		FieldInitValue fiv = new FieldInitValue();
		
		System.out.println("byte-field : " + fiv.byteField);
		System.out.println("short-field : " + fiv.shortField);
		System.out.println("int-field : " + fiv.intField);
		System.out.println("long-field : " + fiv.longField);
		System.out.println();
		System.out.println("boolean-field : " + fiv.booleanField);
		System.out.println("char-field : " + fiv.charField);
		System.out.println();
		System.out.println("float-field : " + fiv.floatField);
		System.out.println("double-field : " + fiv.doubleField);
		System.out.println();
		System.out.println("arr-field : " + fiv.arrField);
		System.out.println("reference-field : " + fiv.referenceField);

	}

}
