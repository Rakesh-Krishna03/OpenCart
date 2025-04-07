package javaPrograms;

import java.util.Arrays;

public class ArrayBubbleSort {

	public static void main(String[] args) {

		int[] array = { 10, 9, 20, 3, 15 };

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

		// Arrays.sort(array);
//		Arrays.sort(array, Collections.reverseOrder());

		System.out.println(Arrays.toString(array));
	}
}
