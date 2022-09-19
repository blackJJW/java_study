package basicAPI;

import java.util.Arrays;

public class Member2 implements Cloneable{

	public String name;
	public int age;
	public int[] scores; // 참조 타입 필드
	public Car car;      // (깊은 복제 대상)
	
	public Member2(String name, int age, int[] scores, Car car) {
		this.name = name;
		this.age = age;
		this.scores = scores;
		this.car = car;
	}
	
	// clone() 메소드 재정의
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 먼저 얕은 복사를 해서 name, age를 복제
		Member2 cloned = (Member2) super.clone(); // Object의 clone() 호출
		// scores를 깊은 복제한다.
		cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
		// car를 깊은 복제한다.
		cloned.car = new Car(this.car.model);
		// 깊은 복제된 Member 객체를 리턴
		return cloned;
	}
	
	public Member2 getMember2() {
		Member2 cloned = null;
		try {
			// 재정의된 clone() 메소드 호출
			cloned = (Member2) clone();
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloned;
	}
}
