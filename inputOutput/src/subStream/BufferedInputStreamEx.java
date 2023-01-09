package subStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamEx {

	public static void main(String[] args) throws Exception {
		long start = 0;
		long end = 0;
		
		FileInputStream fis1 = new FileInputStream(
				"D:\\Users\\jjinw\\Desktop\\GitHub\\study\\java_practice\\inputOutput\\src\\subStream\\p-1.png");
		start = System.currentTimeMillis();
		while(fis1.read() != -1) {}
		end = System.currentTimeMillis();
		System.out.println("사용하지 않았을 때 : " + (end - start) + "ms");
		fis1.close();
		
		FileInputStream fis2 = new FileInputStream(
				"D:\\Users\\jjinw\\Desktop\\GitHub\\study\\java_practice\\inputOutput\\src\\subStream\\p-1.png");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		start = System.currentTimeMillis();
		while(bis.read() != -1) {}
		end = System.currentTimeMillis();
		System.out.println("사용했을 때 : " + (end - start) + "ms");
		bis.close();
		fis2.close();
	}
}
