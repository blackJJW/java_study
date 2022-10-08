package multi_thread;

public class YieldEx {

	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		// ThreadA, ThreadB 모두 실행
		threadA.start();
		threadB.start();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		// ThreadB만 실행
		threadA.work = false;
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		// ThreadA, ThreadB만 모두 실행
		threadA.work = true;
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		// ThreadA, ThreadB만 모두 종료
		threadA.work = false;
		threadB.work = false;
	}

}
