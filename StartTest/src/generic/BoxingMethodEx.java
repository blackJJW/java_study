package generic;

public class BoxingMethodEx {

	public static void main(String[] args) {
		Box<Integer> box1 = Util.<Integer>boxing(100);
		int intValue = box1.get();
		
		Box<String> box2 = Util.boxing("ABC");
		String strValue = box2.get();

	}

}
