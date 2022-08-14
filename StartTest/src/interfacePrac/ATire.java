package interfacePrac;

public class ATire implements Tire{

	@Override
	public void roll() { // Tire 인터페이스 구현
		System.out.println("ATire가 굴러감");
	}
}
