package javaPrograms;

import java.util.Scanner;

public class ArrayFindElementAndIndex {	

	public static void main(String[] args) {
		
		int array[] = {10, 0, 5, 7, 1};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the element to be searched: ");
		int element = sc.nextInt();
		
		int index = searchElement(array, element);
			if(index != -1)
				System.out.println("Element " + element + " is found at index " + index);
			else
				System.out.println("Element not found");
			
		sc.close();
	}
	
	public static int searchElement(int[] arr, int element) {
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == element)
				return i;
		}
		return -1;
	}
}

