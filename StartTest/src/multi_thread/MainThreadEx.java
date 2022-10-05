package multi_thread;

public class MainThreadEx {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		// User1 스레드 생성
		User1 user1 = new User1();
		// 공유 객체 설정
		user1.setCalculator(calculator);
		// User1 스레드 시작
		user1.start();
		
		// User2 스레드 생성
		User2 user2 = new User2();
		// 공유 객체 설정
		user2.setCalculator(calculator);
		// User1 스레드 시작
		user2.start();

	}

}
