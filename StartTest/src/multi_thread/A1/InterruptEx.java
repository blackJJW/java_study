package multi_thread.A1;

public class InterruptEx {

	public static void main(String[] args) {
		Thread thread = new PrintThread2();
		thread.start();
		
		try { Thread.sleep(1000); } catch (InterruptedException e) {}
		
		// 스레드를 종료시키기 위해 InterruptedException을 발생시킴
		thread.interrupt();

	}

}
