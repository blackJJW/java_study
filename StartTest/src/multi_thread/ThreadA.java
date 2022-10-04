package multi_thread;

public class ThreadA extends Thread{
	public ThreadA() {
		setName("ThreadA");
	}
	
	public void run() {
		// ThreadA 실행 내용
		for(int i = 0; i < 2; i++) {
			System.out.println(getName() + "가 출력한 내용");
		}
	}

}
