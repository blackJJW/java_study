package classEx;

public class Car3 {
	// 필드
	String company = "A자동차";
	String model;
	String color;
	int maxSpeed;
	
	// 생성자
	Car3(){
	}
	
	Car3(String model){
		this(model, "은색", 250);  // 호출
	}
	
	Car3(String model, String color){
		this(model, color, 250);  // 호출
	}
	
	Car3(String model, String color, int maxSpeed){
		// 공통 실행 코드
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
