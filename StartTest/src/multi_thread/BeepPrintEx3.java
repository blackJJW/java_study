package multi_thread;

public class BeepPrintEx3 {

	public static void main(String[] args) { // 메인 스레드
		Thread thread = new BeepThread();
		thread.start(); // BeapThread
		
		for(int i = 0; i < 5; i++) {
			System.out.println("beep!!");
			try { Thread.sleep(500); }
			catch(Exception e) {}
		}

	}

}
