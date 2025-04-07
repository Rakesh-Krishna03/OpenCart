package javaPrograms;

public class ArrayRepeatingElements {

	public static void main(String[] args) {

		int[] array = { 1, 2, 1, 3, 2, 4, 2, 1, 2 };
		int max = 0;
		int value = 0;

		for (int i = 0; i < array.length; i++) {
			int count = 1;
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					count++;
				}
			}

			if (count > max) {
				max = count;
				value = array[i];
			}
		}
		System.out.println(value + " is repeating " + max + " times");

	}

}
