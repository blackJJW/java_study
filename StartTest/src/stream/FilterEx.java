package stream;

import java.util.Arrays;
import java.util.List;

public class FilterEx {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("ABC", "DEF", "GHI", "ABC", "A123", "ADE");
		
		names.stream()
			.distinct() // 중복제거
			.forEach(n -> System.out.println(n));
		System.out.println();
		
		names.stream()
			.filter(n -> n.startsWith("A")) // 필터링
			.forEach(n -> System.out.println(n));
		System.out.println();
		
		names.stream()
			.distinct()  // 중복 제거 후 필터링
			.filter(n -> n.startsWith("A"))
			.forEach(n -> System.out.println(n));
	}
}
