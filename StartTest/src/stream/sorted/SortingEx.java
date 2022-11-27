package stream.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingEx {

	public static void main(String[] args) {
		// 숫자 요소일 경우
		IntStream intStream = Arrays.stream(new int[] {5, 3, 2, 1, 4});
		intStream
			.sorted() // 숫자를 오름차순으로 정렬
			.forEach(n -> System.out.print(n + ", "));
		System.out.println();
		
		// 객체 요소일 경우
		List<Student> studentList = Arrays.asList(
				new Student("ABC", 30),
				new Student("DEF", 10),
				new Student("GHI", 20)
				);
		
		studentList.stream()
			.sorted() // 정수를 기준으로 오름차순으로 Student 정렬
			.forEach(s -> System.out.print(s.getScore() + ", "));
		System.out.println();
		
		studentList.stream()
			.sorted( Comparator.reverseOrder() ) // 정수를 기준으로 내림차순으로 Student 정렬
			.forEach(s -> System.out.print(s.getScore() + ", "));
	}
}
