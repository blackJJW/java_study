
public class OperationPromotionExample {

	public static void main(String[] args) {
		char ai = 'A';
		int result = ai + 1;     // 'A'의 유니코드보다 1이 큰 유니코드가 저장
		char na = (char) result; // 'B'가 저장
		
		System.out.println("na = "+ na);

	}

}
