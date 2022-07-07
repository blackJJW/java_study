
public class CheckValueBeforeCasting {

	public static void main(String[] args) {
		int i = 128;
		
		if ((i < Byte.MIN_VALUE) || (i > Byte.MAX_VALUE)) {
			System.out.println("byte 타입으로 변환 불가.");
			System.out.println("값을 확인 해주세요.");
		} else {
			byte b = (byte) i;
			System.out.println(b);
		}

	}

}
