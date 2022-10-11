package multi_thread.A1;

public class PrintThread1 extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	public void run() {
		while(!stop) {
			System.out.println("실행 중...");
		}
		
		// stop이 true일 때
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}

}
