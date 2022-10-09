package multi_thread;

public class WaitNotifyEx {

	public static void main(String[] args) {
		// 공유 객체 생성
		WorkObject sharedObject = new WorkObject();
		
		// ThreadA와 ThreadB 생성
		ThreadA threadA = new ThreadA(sharedObject);
		ThreadB threadB = new ThreadB(sharedObject);
		
		// ThreadA와 ThreadB 실행
		threadA.start();
		threadB.start();

	}

}
