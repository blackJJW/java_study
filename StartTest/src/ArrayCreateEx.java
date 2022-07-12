
public class ArrayCreateEx {

	public static void main(String[] args) {
		String[] languages = {"Java", "Python", "C++"};
		
		for (int i = 0; i < 3; i++) {
			System.out.printf("%d : %s \n", i, languages[i]);
		}
		System.out.println();
		languages[1] = "JavaScript";
		
		for (int i = 0; i < 3; i++) {
			System.out.printf("%d : %s \n", i, languages[i]);
		}

	}

}
