package subStream.serialVersionUID;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerialVersionUIDEx2 {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ClassC classC = (ClassC) ois.readObject();
		System.out.println("field1 : " + classC.field1);
	}
}
