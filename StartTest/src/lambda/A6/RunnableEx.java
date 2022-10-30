package lambda.A6;

public class RunnableEx {

	public static void main(String[] args) {
		// 람다식(스레드가 실행되는 코드)
		Runnable runnable = () -> {
			for(int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
