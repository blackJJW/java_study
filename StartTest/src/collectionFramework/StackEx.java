package collectionFramework;

import java.util.Stack;

public class StackEx {

	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<Coin>();
		
		// 동전을 끼움
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		while(!coinBox.isEmpty()) { // 동전 케이스가 비었는지 확인
			// 동전 케이스에서 제일 위의 동전 꺼내기
			Coin coin = coinBox.pop();
			System.out.println("꺼내온 동전 : " + coin.getValue() + " 원");
		}
	}
}
