package generic;

public class BoxEx {

	public static void main(String[] args) {
		Box box = new Box();
		box.set("ABC");                   // String -> Object (자동 타입 변환)
		String name = (String) box.get(); // Object -> String (강제 타입 변환)
		
		box.set(new Apple());             // Apple -> Object (자동 타입 변환)
		Apple apple = (Apple) box.get();  // Object -> Apple (강제 타입 변환) 

	}
}
