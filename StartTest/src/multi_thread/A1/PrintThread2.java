package multi_thread.A1;

public class PrintThread2 extends Thread{
	public void run() {
		while(true) {
			System.out.println("실행 중...");
			if(Thread.interrupted()) {
				break; // while문을 빠져나욤
			}
		}
		
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}
