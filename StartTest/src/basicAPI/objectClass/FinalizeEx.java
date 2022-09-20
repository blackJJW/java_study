package basicAPI.objectClass;

public class FinalizeEx {

	public static void main(String[] args) {
		Counter counter = null;
		for(int i = 1; i <= 50; i++) {
			counter = new Counter(i);
			
			counter = null; // Counter 객체를 garbage로 만듦
			
			System.gc(); // Garbage collector 요청
		}

	}

}
