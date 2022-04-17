package org.opentutorials.javatutorials.numberstring;

public class String {

	public static void main(java.lang.String[] args) {
		// 문자는 작은따옴표('')로 감싸야 한다.
		System.out.println('생');
		
		// 문자열은 큰따옴표("")로 감싸야 한다.
		System.out.println("생활코딩");
		
		// 문자의 연산
		System.out.println("생활코딩"+"입니다");
		
		// 이스케이프
		System.out.println("egoing said \"Welcome programming world\"");
		
		// 여러줄 표시
		System.out.println("java\nC++\nPython");

		int a; //정수 변수선언
		a = 1;
		System.out.println(a+1); // 2
		
		a = 2;
		System.out.println(a+1); // 3
		
		double b; // 실수 변수 선언
		b = 1.1;
		System.out.println(b+1);
		
		
	    //String first;
	    //first = "coding";
		//String a, b;
		//a = "my";
		//b ="coding";
		
		/*
		System.out.println(first);
		System.out.println(a + b);
		*/
		int e = 10;
		int f = 3;
		
		float c = 10.0F;
		float d = 3.0F;
		
		System.out.println(e/f);
		System.out.println(c/d);
		System.out.println(e/d);
		
		int i = 3;
		i++; // i = i+1
		
		System.out.println(i); // 4
		++i;
		System.out.println(i); // 5
		System.out.println(++i); // 6
		System.out.println(i++); // 6
		System.out.println(i); // 7
		
	
		
	}

}
