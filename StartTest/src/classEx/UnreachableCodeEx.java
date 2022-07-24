package classEx;

public class UnreachableCodeEx {
	int plus(int x, int y) {
		int result = x + y;
		return result;
		System.out.println(result); // Unreachable code
	}
}
