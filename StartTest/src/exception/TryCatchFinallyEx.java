package exception;

public class TryCatchFinallyEx {

	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("Java.lang.String");
		} catch(ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않음.");
		}

	}

}
