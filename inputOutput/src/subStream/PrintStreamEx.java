package subStream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamEx {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/Temp/file.txt");
		PrintStream ps = new PrintStream(fos);
		
		ps.println("[ 프린트 보조 스트림 ]");
		ps.print("마치");
		ps.println("프린터가 출력하는 것처럼");
		ps.println("데이터를 출력");
		
		ps.flush();
		ps.close();
		fos.close();
	}
}
