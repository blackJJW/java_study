package basicAPI.Math_Random_class;

import java.util.Arrays;
import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {
		// 선택 번호
		int[] selectNumber = new int[6];
		// 선택 번호 6개가 저장될 배열 생성
		
		// 선택 번호를 얻기 위한 Random 객체 생성
		Random random = new Random(3);
		System.out.print("선택 번호 : ");
		for(int i = 0; i < 6; i++) {
			// 선택 번호를 얻어 배열에 저장
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();
		
		// 당첨 번호
		// 당첨 번호 6개가 저장될 배열 생성
		int[] winningNumber = new int[6];
		random = new Random(5); // 당첨 번호를 얻기 위한 Random 객체 생성
		System.out.print("당첨 번호 : ");
		for(int i = 0; i < 6; i++) {
			// 선택 번호를 얻어 배열에 저장
			winningNumber[i] = random.nextInt(45) + 1;
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();
		
		// 당첨 여부
		// 비교하기 전에 정렬
		Arrays.sort(selectNumber);
		Arrays.sort(winningNumber);
		// 배열 항목 값 비교
		boolean result = Arrays.equals(selectNumber, winningNumber);
		System.out.print("당첨 여부 : ");
		if(result) {
			System.out.println("1등 당첨");
		} else {
			System.out.println("당첨 안됨");
		}

	}

}
