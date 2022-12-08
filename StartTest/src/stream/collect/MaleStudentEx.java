package stream.collect;

import java.util.Arrays;
import java.util.List;

public class MaleStudentEx {

	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
				new Student("ABC", 10, Student.Sex.MALE),
				new Student("DEF", 6, Student.Sex.FEMALE),
				new Student("GHI", 10, Student.Sex.MALE),
				new Student("JKL", 6, Student.Sex.FEMALE)
		);
		
		MaleStudent maleStudent = totalList.stream()
				.filter(s -> s.getSex() == Student.Sex.MALE)
				.collect(MaleStudent :: new, MaleStudent :: accumulate, MaleStudent :: combine);
		
		maleStudent.getList().stream()
			.forEach(s -> System.out.println(s.getName()));
	}
}
