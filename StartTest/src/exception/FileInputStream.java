package exception;

public class FileInputStream implements AutoCloseable{
	private String file;
	
	public FileInputStream(String file) {
		this.file = file;
	}
	
	public void read() {
		System.out.println(file + "을 읽는다.");
	}
	
	@Override
	public void close() throws Exception{
		System.out.println(file + "을 닫음");
	}
}
