package javaPrograms;

public class ArraySecondLargest {

	public static void main(String[] args) {
		int array[] = { 5, 20, 12, 11, 19, 18 };
		int largest = 0;
		int secondLargest = 0;
		
		for(int num : array) {
			if(num > largest) {
				secondLargest = largest;
				largest = num;
			}
			else
				if(num > secondLargest && num!= largest)
					secondLargest = num;
		}

		System.out.println(largest);
		System.out.println(secondLargest);
	}
}