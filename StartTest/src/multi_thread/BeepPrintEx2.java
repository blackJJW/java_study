package multi_thread;

public class BeepPrintEx2 {

	public static void main(String[] args) { // 메인 스레드
		Runnable beepTask = new BeepTask();
		Thread thread = new Thread(beepTask);
		thread.start(); // BeepRunable
		
		for(int i = 0; i < 5; i++) {
			System.out.println("beep!!");
			try { Thread.sleep(500); }
			catch(Exception e) {}
		}

	}

}
