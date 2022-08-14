package interfacePrac;

public class BTire implements Tire{

	@Override
	public void roll() { // Tire 인터페이스 구현
		System.out.println("BTire가 굴러감");
	}
}
