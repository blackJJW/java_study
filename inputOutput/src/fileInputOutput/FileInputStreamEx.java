package fileInputOutput;

import java.io.FileInputStream;

public class FileInputStreamEx {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("D:\\ {path} \\FileInputStreamEx.java");
			int data;
			
			// 1byte씩 읽고 콘솔에 출력
			while ( (data = fis.read() ) != -1) {
				System.out.write(data);
			}
			fis.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
