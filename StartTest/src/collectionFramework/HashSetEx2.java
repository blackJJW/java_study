package collectionFramework;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx2 {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		// 인스턴스는 다르지만 내부 데이터가 동일하므로 객체 1개만 저장
		set.add(new Member("ABC", 30));
		set.add(new Member("ABC", 30));
		
		System.out.println("총 객체 수 : " + set.size()); // 저장된 객체 수 얻기
	}
}
