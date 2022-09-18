package basicAPI;

public class SmartPhoneEx {

	public static void main(String[] args) {
		SmartPhone myPhone = new SmartPhone("Google", "Android");
		
		String strObj = myPhone.toString();
		System.out.println(strObj);
		
		System.out.println(myPhone);
		// myPhone.toString()을 자동 호출해서 리턴값을 얻은 후 호출

	}

}
