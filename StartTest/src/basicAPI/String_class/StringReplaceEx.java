package basicAPI.String_class;

public class StringReplaceEx {

	public static void main(String[] args) {
		String oldStr = "자바는 객체지향언어. 자바는 풍부한 API를 지원";
		String newStr = oldStr.replace("자바","JAVA");
		System.out.println(oldStr);
		System.out.println(newStr);

	}

}
