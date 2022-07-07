
public class StringCompareEx {

	public static void main(String[] args) {
		String strVar1 = "AAA";
		String strVar2 = "AAA";
		String strVar3 = new String("AAA"); 
		
		boolean result1 = strVar1.equals(strVar2);
		boolean result2 = strVar2.equals(strVar3);
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
	}

}
