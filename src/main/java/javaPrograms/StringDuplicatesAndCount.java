package javaPrograms;

import java.util.HashMap;
import java.util.Map;

public class StringDuplicatesAndCount {

	public static void main(String[] args) {

		String str = "Rakesh Kumar";

		str = str.toLowerCase().replaceAll("\\s", "");
		
		Map<Character, Integer> charCountMap = new HashMap<>();
		
		for(char c : str.toCharArray()) {
			charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
		}
		
		for(Map.Entry<Character, Integer> entry: charCountMap.entrySet()) {
			if(entry.getValue() > 1) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		}
	}

}
