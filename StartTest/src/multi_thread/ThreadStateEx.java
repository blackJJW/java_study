package multi_thread;

public class ThreadStateEx {

	public static void main(String[] args) {
		StatePrintThread statePrintThread = 
				new StatePrintThread(new TargetThread());
		
		statePrintThread.run();
	}

}
