package javaPrograms;

import java.util.HashSet;

public class ArraySumCombination {

	public static void main(String[] args) {

		int array[] = { 3, 8, 9, 2, 7 };
		int sum = 9;

		HashSet<Object> set = new HashSet<>();

		for (int num : array) {
			int comp = sum - num;
			if (set.contains(comp)) {
				System.out.println(num + " + " + comp + " = " + sum);
			}

			set.add(num); // Add the current number to the set
		}
	}
}
