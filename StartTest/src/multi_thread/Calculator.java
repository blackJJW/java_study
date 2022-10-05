package multi_thread;

public class Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	// 계산기 메모리에 값을 저장하는 메소드
	public void setMemory(int memory) {
		this.memory = memory; // 매개값을 memory 필드에 저장
		// 스레드를 2초간 일시 정지 시킴
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
		                   // 스레드의 이름                              메모리의 값
	}

}
