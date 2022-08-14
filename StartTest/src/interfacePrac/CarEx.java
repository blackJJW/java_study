package interfacePrac;

public class CarEx {

	public static void main(String[] args) {

		Car myCar = new Car();
		
		myCar.run();
		
		myCar.tires[0] = new BTire();
		myCar.tires[1] = new BTire();
		
		myCar.run();

	}

}
