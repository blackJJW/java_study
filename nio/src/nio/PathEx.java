package nio;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PathEx {

	public static void main(String[] args) throws Exception {
		Path path = Paths.get("src/nio/PathEx.java");
		System.out.println("[ 파일명 ] " + path.getFileName());
		System.out.println("[ 부목 디렉토리명 ] : " + path.getParent().getFileName());
		System.out.println("중첩 경로수 : " + path.getNameCount());
		
		System.out.println();
		for(int i = 0; i < path.getNameCount(); i++) {
			System.out.println(path.getName(i));
		}
		
		System.out.println();
		Iterator<Path> iterator = path.iterator();
		while(iterator.hasNext()) {
			Path temp = iterator.next();
			System.out.println(temp.getFileName());
		}
	}
}
