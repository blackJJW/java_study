package stream;

import java.util.Arrays;
import java.util.List;

public class StreamPipelinesEx {

	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("ABC", Member.MALE, 30),
				new Member("DEF", Member.FEMALE, 20),
				new Member("GHI", Member.MALE, 45),
				new Member("JKL", Member.FEMALE, 27)
				);
		
		double ageAvg = list.stream()
				.filter(m -> m.getSex() == Member.MALE)
				.mapToInt(Member :: getAge)
				.average()
				.getAsDouble();
		
		System.out.println("남자 평균 나이 : " + ageAvg);
	}
}
