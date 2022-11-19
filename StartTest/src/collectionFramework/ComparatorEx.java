package collectionFramework;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparatorEx {

	public static void main(String[] args) {
		/*
		 * TreeSet<Fruit> treeSet = new TreeSet<Fruit>();
		 * // Fruit이 Comparable을 구현하지 않았기 때문에 예외 발생
		 * treeSet.add(new Fruit("grape", 3000));
		 * treeSet.add(new Fruit("water melon", 10000));
		 * treeSet.add(new Fruit("strawberry", 6000)); 
		 * */
		
		TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new DescendingComparator());
		                                            // 내림차순 정렬자 제공
		// 저장될 때 가격을 기준으로 내림차순 정렬됨
		treeSet.add(new Fruit("grape", 3000));
		treeSet.add(new Fruit("watermelon", 10000));
		treeSet.add(new Fruit("strawberry", 6000));
		
		Iterator<Fruit> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			Fruit fruit = iterator.next();
			System.out.println(fruit.name + " : " + fruit.price);
		}
	}
}
