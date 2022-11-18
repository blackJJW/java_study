package collectionFramework;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapEx2 {

	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<Integer, String>();
		scores.put(new Integer(87), "ABC");
		scores.put(new Integer(98), "DEF");
		scores.put(new Integer(75), "GHI");
		scores.put(new Integer(95), "JKL");
		scores.put(new Integer(80), "MNO");
		
		NavigableMap<Integer, String> descendingMap = scores.descendingMap();
		Set<Map.Entry<Integer, String>> descendingEntrySet = descendingMap.entrySet();
		for(Map.Entry<Integer, String> entry : descendingEntrySet) {
			System.out.print(entry.getKey() + " - " + entry.getValue() + " ");
		}
		System.out.println();
		
		NavigableMap<Integer, String> ascendingMap = descendingMap.descendingMap();
		Set<Map.Entry<Integer, String>> ascendingEntrySet = ascendingMap.entrySet();
		for(Map.Entry<Integer, String> entry : ascendingEntrySet) {
			System.out.print(entry.getKey() + " - " + entry.getValue() + " ");
		}
	}
}
