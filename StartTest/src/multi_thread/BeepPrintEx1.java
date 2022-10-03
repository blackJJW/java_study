package multi_thread;

import java.awt.Toolkit;

public class BeepPrintEx1 {

	public static void main(String[] args) {
		// Toolkit 객체 얻기
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for(int i = 0; i < 5; i++) {
			toolkit.beep(); // 비프음 발생
			try {Thread.sleep(500);} catch(Exception e) {}
		}         // 0.5초간 일시 정지
		
		for(int i = 0; i < 5; i++) {
			System.out.println("beep!!");
			try {Thread.sleep(500);} catch(Exception e) {}
		}          // 0.5초간 일시 정지

	}

}
