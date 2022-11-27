package stream;

import java.util.Arrays;
import java.util.List;

public class MapEx {

	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("ABC", 10),
				new Student("DEF", 20),
				new Student("GHI", 30)
				);
		
		studentList.stream()
			.mapToInt(Student :: getScore)
			.forEach(score -> System.out.println(score));

	}
}
