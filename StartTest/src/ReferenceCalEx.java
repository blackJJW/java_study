
public class ReferenceCalEx {

	public static void main(String[] args) {
		String name1 = "John";
		String name2 = "John";
		String name3 = new String("John");
		
		System.out.println(name1 == name2);
		System.out.println(name1 == name3);
	}

}
