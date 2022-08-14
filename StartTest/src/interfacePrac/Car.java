package interfacePrac;

public class Car {

	Tire[] tires = {
			new ATire(),
			new ATire(),
			new ATire(),
			new ATire()
	};
	
	void run() {
		for(Tire tire : tires) {
			tire.roll();
		}
	}
}
