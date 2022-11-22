package stream;

import java.util.Arrays;
import java.util.List;

public class MapAndReduceEx {

	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("ABC", 10),
				new Student("DEF", 20),
				new Student("GHI", 30)
				);
		
		double avg = studentList.stream()
				// 중간 처리(학생 객체를 점수로 매핑)
				.mapToInt(Student :: getScore)
				// 최동 처리(평균 점수)
				.average()
				.getAsDouble();
		
		System.out.println("평균 점수 : " + avg);

	}
}
