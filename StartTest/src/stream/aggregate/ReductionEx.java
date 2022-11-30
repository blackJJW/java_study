package stream.aggregate;

import java.util.Arrays;
import java.util.List;

public class ReductionEx {

	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
				new Student("ABC", 92),
				new Student("DEF", 95),
				new Student("GHI", 88)
				);
		
		// sum() 이용
		int sum1 = studentList.stream()
				.mapToInt(Student :: getScore)
				.sum();
		
		// reduce(BinaryOperator<Integer> ac) 이용
		int sum2 = studentList.stream()
				.map(Student :: getScore)
				.reduce((a, b) -> a+b)
				.get();
		
		// reduce(int identity, IntBinaryOperator op) 이용
		int sum3 = studentList.stream()
				.map(Student :: getScore)
				.reduce(0, (a, b) -> a+b);
		
		System.out.println("sum1 : " + sum1);
		System.out.println("sum2 : " + sum2);
		System.out.println("sum3 : " + sum3);
	}
}
