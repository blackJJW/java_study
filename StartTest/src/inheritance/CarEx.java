package inheritance;

public class CarEx {

	public static void main(String[] args) {
		Car car = new Car(); // Car 객체 생성
		
		for(int i = 1; i <= 5; i++) {
			int problemLocation = car.run();
			if(problemLocation != 0) {
				System.out.println(car.tires[problemLocation - 1].location 
						           + " ATire로 교체");
				car.tires[problemLocation - 1] = 
						new ATire(car.tires[problemLocation - 1].location, 15);
			}
			System.out.println("--------------------------------");
		}
	}
}
