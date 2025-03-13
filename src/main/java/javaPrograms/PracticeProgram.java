package javaPrograms;

public class PracticeProgram {
	public static void main(String[] args) {

		int arr1[] = { 1, 2, 3, 10, 8, 9, 11 };
		int largest = 0;
		int secondLargest = 0;

		for (int num : arr1) {
			if (num > largest) {
				secondLargest = largest;
				largest = num;
			} else if (num > secondLargest && num != largest)
				secondLargest = num;
		}

		System.out.println(largest);
		System.out.println(secondLargest);
	}
}
