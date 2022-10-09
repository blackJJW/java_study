package multi_thread.A1;

public class ConsumerThread extends Thread{
	private DataBox dataBox;
	
	public ConsumerThread(DataBox dataBox) {
		// 공유 객체를 필드에 저장
		this.dataBox = dataBox;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 3; i++) {
			// 새로운 데이터를 읽음
			String data = dataBox.getData();
		}
	}
}
