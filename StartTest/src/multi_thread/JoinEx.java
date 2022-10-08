package multi_thread;

public class JoinEx {

	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		
//		try {
//			// sumThread가 종료될 때까지 메인 스레드를 일시 정지시킴
//			sumThread.join();
//		} catch (InterruptedException e) {
//		}
		
		System.out.println("1 ~ 100 합 : " + sumThread.getSum());

	}

}
