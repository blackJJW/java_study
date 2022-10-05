package multi_thread;

public class User1 extends Thread{
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator) {
		// 스레드 이름을 User1로 설정
		this.setName("User1");
		// 공유 객체인 Caculator를 필드에 저장
		this.calculator = calculator;
	}
	
	public void run() {
		// 공유 객체인 Calculator의 메모리에 100d을 저장
		calculator.setMemory(100);
	}

}
