package collectionFramework;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx2 {

	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<Student, Integer>();
		
		map.put(new Student(1, "ABC"), 95);
		map.put(new Student(1, "ABC"), 95);
		// 학번과 이름이 동일한 Student를 키로 저장
		
		// 저장된 총 Map.Entry 수 얻기
		System.out.println("총 Entry 수 : " + map.size());
	}
}
