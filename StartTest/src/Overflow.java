
public class Overflow {

	public static void main(String[] args) {
		int x = 1000000;
		int y = 1000000;
		long z1 = (long)x * y;
		long z2 = x * (long)y;
		
		System.out.println("z1 : " + z1);
		System.out.println("z2 : " + z2);

	}

}
