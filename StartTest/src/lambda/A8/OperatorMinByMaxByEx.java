package lambda.A8;

import java.util.function.BinaryOperator;

public class OperatorMinByMaxByEx {

	public static void main(String[] args) {
		BinaryOperator<Fruit> binaryOperator;
		Fruit fruit;
		
		binaryOperator = BinaryOperator.minBy(
				(f1, f2) -> Integer.compare(f1.price, f2.price)
				);
		fruit = binaryOperator.apply(
				new Fruit("strawberry", 6000), 
				new Fruit("water melon", 10000)
				);
		System.out.println(fruit.name);
		
		binaryOperator = BinaryOperator.maxBy(
				(f1, f2) -> Integer.compare(f1.price, f2.price)
				);
		fruit = binaryOperator.apply(
				new Fruit("strawberry", 6000), 
				new Fruit("water melon", 10000)
				);
		System.out.println(fruit.name);
	}
}
