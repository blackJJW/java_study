package exception;

public class TryCatchFinallyRuntimeExceptionEx {

	public static void main(String[] args) {
		String data1 = null;
		String data2 = null;
		try {
			data1 = args[0];
			data2 = args[1];
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("���� �Ű����� ���� ����");
			System.out.println("[ ���� ��� ]");
			System.out.println("java TryCatchFinallyRuntimeExceptionEx num1 num2");
			return;
		}
		
		try {
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1 + "+" + data2 + '=' + result);
		} catch(NumberFormatException e) {
			System.out.println("���ڷ� ��ȯ �Ұ�");
		} finally {
			System.out.println("�ٽ� �����ϼ���.");
		}

	}

}