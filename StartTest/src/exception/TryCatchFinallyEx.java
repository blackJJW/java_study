package exception;

public class TryCatchFinallyEx {

	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("Java.lang.String");
		} catch(ClassNotFoundException e) {
			System.out.println("Ŭ������ �������� ����.");
		}

	}

}
