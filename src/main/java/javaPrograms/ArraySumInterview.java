package javaPrograms;

public class ArraySumInterview {

	public static void main(String[] args) {

		int array[] = { 2, 7, 11, 15, 10, 30, 40, 20, 25, 35, 43, 48 };
		int result = 50;

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] + array[j] == result) {
					System.out.println(array[i] + " + " + array[j] + " = " + result);
				}
			}
		}
	}
}