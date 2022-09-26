package basicAPI.StringTokenizer_class;

public class StringSplitEx {

	public static void main(String[] args) {
		String text = "ABC&DEF,GHI,JKL-MNO";
		
		String[] txt = text.split("&|,|-");
		
		for (String tmp : txt) {
			System.out.println(tmp);
		}

	}

}
