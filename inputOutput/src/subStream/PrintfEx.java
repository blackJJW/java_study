package subStream;

import java.util.Date;

public class PrintfEx {

	public static void main(String[] args) {
		System.out.printf("상품의 가격 : %d 원\n", 123);
		System.out.printf("상품의 가격 : %6d 원\n", 123);
		System.out.printf("상품의 가격 : %-6d 원\n", 123);
		System.out.printf("상품의 가격 : %06d 원\n", 123);
		
		System.out.printf("반지름이 %d인 원의 넓이 : %10.2f\n", 10, Math.PI * 10 * 10);
		
		System.out.printf("%6d | %-10s | %10s\n", 1, "John", "developer");
		
		Date now = new Date();
		System.out.printf("오늘은 %tY년 %tm월 %td일 \n", now, now, now);
		System.out.printf("오늘은 %1$tY년 %1$tm월 %1$td일 \n", now);
		System.out.printf("현재 %1$tH시 %1$tM분 %1$tS초 \n", now);

	}

}
