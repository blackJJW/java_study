package generic;

public class BoundTypeParameterEx {

	public static void main(String[] args) {
		// String str = Util.compare("a", "b"); (x)
		//                  String은 Number 타입이 아님
		
		int result1 = Util.compare(10, 20);
		                 // 20 : int -> Integer (자동 Boxing)
		System.out.println(result1);
		
		int result2 = Util.compare(4.5, 3);
		                 // 4.5 : double -> Double (자동 Boxing)
		System.out.println(result2);

	}

}
