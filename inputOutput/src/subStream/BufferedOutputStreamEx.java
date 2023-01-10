package subStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamEx {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		int data = -1;
		long start = 0;
		long end = 0;
		
		fis = new FileInputStream(
				"D:\\Users\\jjinw\\Desktop\\GitHub\\study\\java_practice\\inputOutput\\src\\subStream\\p-1.png"
				);
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream("C:/Temp/p-1.png");
		start = System.currentTimeMillis();
		while((data = bis.read()) != -1) {
			fos.write(data);
		}
		fos.flush();
		end = System.currentTimeMillis();
		fos.close(); bis.close(); fis.close();
		System.out.println("사용하지 않았을 때 : " 
		                    + (end - start) + " ms");
		
		fis = new FileInputStream(
				"D:\\Users\\jjinw\\Desktop\\GitHub\\study\\java_practice\\inputOutput\\src\\subStream\\p-1.png"
				);
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream("C:/Temp/p-1.png");
		bos = new BufferedOutputStream(fos);
		start = System.currentTimeMillis();
		while((data = bis.read()) != -1) {
			bos.write(data);
		}
		bos.flush();
		end = System.currentTimeMillis();
		bos.close(); fos.close(); bis.close(); fis.close();
		System.out.println("사용했을 때 : " 
		                    + (end - start) + " ms");

	}
}
