package stream.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByEx {

	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
				new Student("ABC", 10, Student.Sex.MALE, Student.City.Seoul),
				new Student("DEF", 6, Student.Sex.FEMALE, Student.City.Pusan),
				new Student("GHI", 10, Student.Sex.MALE, Student.City.Pusan),
				new Student("JKL", 6, Student.Sex.FEMALE, Student.City.Seoul)
		);
		
		Map<Student.Sex, List<Student>> mayBySex = totalList.stream()
				.collect(Collectors.groupingBy(Student :: getSex));
		
		System.out.print("[ 남학생 ]");
		mayBySex.get(Student.Sex.MALE).stream()
			.forEach(s -> System.out.print(s.getName() + " "));
		
		System.out.print("\n[ 여학생 ]");
		mayBySex.get(Student.Sex.FEMALE).stream()
			.forEach(s -> System.out.print(s.getName() + " "));
		
		System.out.println();
		
		Map<Student.City, List<String>> mapByCity = totalList.stream()
				.collect(
					Collectors.groupingBy(
						Student :: getCity,
						Collectors.mapping(Student :: getName, Collectors.toList())
					)
				);
		
		System.out.print("\n[ 서울 ]");
		mapByCity.get(Student.City.Seoul).stream()
			.forEach(s -> System.out.print(s + " "));
		
		System.out.print("\n[ 부산 ]");
		mapByCity.get(Student.City.Pusan).stream()
			.forEach(s -> System.out.print(s + " "));
	}
}
