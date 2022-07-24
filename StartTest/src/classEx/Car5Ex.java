package classEx;

public class Car5Ex {

	public static void main(String[] args) {
		Car5 myCar = new Car5();
		myCar.keyTurnOn();
		myCar.run();
		int speed = myCar.getSpeed();
		System.out.println("현재 속도 : " + speed + " km/h");

	}

}
