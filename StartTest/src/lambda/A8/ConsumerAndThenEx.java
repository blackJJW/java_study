package lambda.A8;

import java.util.function.Consumer;

public class ConsumerAndThenEx {

	public static void main(String[] args) {
		Consumer<Member> consumerA = (m) -> {
			System.out.println("consumerA : " + m.getName());
		};
		
		Consumer<Member> consumerB = (m) -> {
			System.out.println("consumerB : " + m.getId());
		};
		
		Consumer<Member> consumerAB = consumerA.andThen(consumerB);
		
		consumerAB.accept(new Member("ABC", "A", null));

	}

}
