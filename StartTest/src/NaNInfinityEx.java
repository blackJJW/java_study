
public class NaNInfinityEx {

	public static void main(String[] args) {
		int x = 5;
		double y = 0.0;
		
		double z = x / y;
		
		if (Double.isInfinite(z) || Double.isNaN(z)) {
			System.out.println("error!!!");
		} else {
			System.out.println(z + 5);
		}
	}

}
