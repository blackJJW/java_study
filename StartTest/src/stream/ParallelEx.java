package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelEx {

	public static void main(String[] args) {
		List<String> list = Arrays.asList(
				"ABC", "DEF", "GHI", 
				"JKL", "MNO"
				);
		
		// 순차 처리
		Stream<String> stream = list.stream();
		stream.forEach(ParallelEx :: print);
				    // 메소드 참조(s -> ParallelEx.print(s)와 동일)
		System.out.println();
		
		// 병렬 처리
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(ParallelEx :: print);
		                    // 메소드 참조
	}
	
	public static void print(String str) {
		System.out.println(str + " : " + Thread.currentThread().getName());
	}
}
