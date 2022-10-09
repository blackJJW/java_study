package multi_thread;

public class ThreadB extends Thread{
	private WorkObject workObject;
	
	public ThreadB(WorkObject workObject) {
		// 공유 객체를 매개값으로 받아 필드에 저장
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		// 공유 객체의 methodB를 10번 반복 호출
		for(int i = 0; i < 10; i++) {
			workObject.methodB();
		}
	}

}
