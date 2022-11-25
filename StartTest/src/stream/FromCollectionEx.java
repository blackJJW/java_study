package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FromCollectionEx {

	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("ABC", 10),
				new Student("DEF", 20),
				new Student("GHI", 30)
				);
		
		Stream<Student> stream = studentList.stream();
		stream.forEach(s -> System.out.println(s.getName()));
	}
}
