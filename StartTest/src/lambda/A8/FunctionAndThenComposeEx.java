package lambda.A8;

import java.util.function.Function;

public class FunctionAndThenComposeEx {

	public static void main(String[] args) {
		Function<Member, Address> functionA;
		Function<Address, String> functionB;
		Function<Member, String> functionAB;
		String city;
		
		functionA = (m) -> m.getAddress();
		functionB = (a) -> a.getCity();
		
		functionAB = functionA.andThen(functionB);
		city = functionAB.apply(
				new Member("ABC", "A", new Address("Korea", "Seoul"))
				);
		System.out.println("city : " + city);
		
		functionAB = functionB.compose(functionA);
		city = functionAB.apply(
				new Member("ABC", "A", new Address("Korea", "Seoul"))
				);
		System.out.println("city : " + city);
	}

}
