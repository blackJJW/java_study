package fileChannel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyMethodEx {

	public static void main(String[] args) throws IOException {
		Path from = Paths.get("src/fileChannel/p-1.png");
		Path to = Paths.get("src/fileChannel/p-2.png");
		
		Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("파일 복사 성공");
	}
}
