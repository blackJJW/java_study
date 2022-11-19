package collectionFramework;

import java.util.Iterator;
import java.util.TreeSet;

public class ComaprableEx {

	public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<Person>();
		
		// 저장될 때 나이 순으로 저장
		treeSet.add(new Person("ABC", 45));
		treeSet.add(new Person("DEF", 25));
		treeSet.add(new Person("GHI", 31));
		
		Iterator<Person> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			Person person = iterator.next();
			System.out.println(person.name + " : " + person.age);
		}
	}

}
