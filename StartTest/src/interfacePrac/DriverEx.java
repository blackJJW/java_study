package interfacePrac;

public class DriverEx {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.driver(bus); // 자동 타입 변환: Vehicle vehicle = bus;
		driver.driver(taxi);// 자동 타입 변환: Vehicle vehicle = taxi;
	}
}
