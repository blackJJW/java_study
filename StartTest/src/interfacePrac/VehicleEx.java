package interfacePrac;

public class VehicleEx {

	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		
		vehicle.run();
		//vehicle.checkFare(); // (x) 
		               // Vehicle 인터페이스에는 checkFare()가 없음
		
		Bus bus = (Bus) vehicle; // 강제 타입 변환
		
		bus.run();
		bus.checkFare(); // Bus 클래스에는 checkFare()가 있음
	}
}
