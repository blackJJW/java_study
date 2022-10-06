package multi_thread;

public class StatePrintThread extends Thread{
	private Thread targetThread;
	
	public StatePrintThread(Thread targetThread) {
		                   // 상태를 조사할 스레드
		this.targetThread = targetThread;
	}
	
	public void run() {
		while(true) {
			// 스레드 상태 얻기
			Thread.State state = targetThread.getState();
			System.out.println("targetThread state : " + state);
			
			// 객체 생성 상태일 경우 실행 대기 상태로 만듦
			if(state == Thread.State.NEW) {
				targetThread.start();
			}
			
			// 종료 상태일 경우 while문을 종료
			if(state == Thread.State.TERMINATED) {
				break;
			}
			
			try {
				// 0.5초간 일시 정지
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}

}
