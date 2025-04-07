package javaPrograms;

import java.util.HashMap;
import java.util.Map;

public class PracticeProgram {
	public static void main(String[] args) {
		
		String str = "Rakesh Kumar";
		
		// Convert string to lowercase and remove spaces if needed
        str = str.toLowerCase().replaceAll("\\s+", "");

        // Create a HashMap to store character counts
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Count each character's occurrences
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Print duplicate characters and their count
        System.out.println("Duplicate characters and their occurrences:");
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
            }
        }
	}
}