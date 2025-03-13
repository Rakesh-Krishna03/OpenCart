package javaPrograms;

import java.util.Arrays;

public class ArrayReverse {
	public static void main(String[] args) {
		
		Object[] arr = {1, 2, "rak", 4, 5, 's'};
	
		int left = 0;
		int right = arr.length-1;
		
		while(left<right) {
			Object temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			
			left++; 
			right--;
		}
		System.out.println(Arrays.toString(arr));
	}
}
