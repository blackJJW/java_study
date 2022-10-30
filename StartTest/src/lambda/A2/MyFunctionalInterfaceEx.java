package lambda.A2;

public class MyFunctionalInterfaceEx {

	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		fi = () -> {
			String str = "method call1";
			System.out.println(str);
		};
		fi.method();
		
		fi = () -> { System.out.println("method call2"); };
		fi.method();
		
		fi = () -> System.out.println("method call3");
		// 실행문이 하나라면 중괄호 {}는 생략 가능
		fi.method();
	}
}
