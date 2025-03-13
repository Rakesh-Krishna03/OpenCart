package javaPrograms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayMerge2ArrayElements {

	public static void main(String[] args) {

		int[] array1 = { 1, 2, 3 };
		int[] array2 = { 4, 5, 6 };

		// enhanced loop
		int[] mergedArray1 = new int[array1.length + array2.length];
		int index = 0;

		for (int num : array1)
			mergedArray1[index++] = num;
		for (int num : array2)
			mergedArray1[index++] = num;

		System.out.println(Arrays.toString(mergedArray1));
		
		// Using System.arraycopy - efficient way
		
		int[] mergedArray2 = new int[array1.length + array2.length];
		
		System.arraycopy(array1, 0, mergedArray2, 0, array1.length);
		System.arraycopy(array2, 0, mergedArray2, array1.length, array2.length);
		
		System.out.println(Arrays.toString(mergedArray2));
		
		// Using IntSteram.concat 
		
		int[] mergedArray3 = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray();
		
		
		System.out.println(Arrays.toString(mergedArray3));
		
	}
}
