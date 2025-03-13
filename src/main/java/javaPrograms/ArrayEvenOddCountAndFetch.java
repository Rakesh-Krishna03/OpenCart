package javaPrograms;

import java.util.ArrayList;
import java.util.List;

public class ArrayEvenOddCountAndFetch {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		evenOddCount(array);
		
		ArrayEvenOddCountAndFetch fet = new ArrayEvenOddCountAndFetch();
		fet.fetchEvenOdd(array);
	}
	
	public static void evenOddCount(int[] arr) {
		int evenCount = 0;
		int oddCount = 0;
		for(int num: arr) {
			if(num%2==0)
				evenCount++;
			else
				oddCount++;
		}
		System.out.println("EvenCount: " + evenCount);
		System.out.println("OddCount: " + oddCount);
	}
	
	public void fetchEvenOdd(int[] arr) {
		List<Integer> evenArray = new ArrayList<Integer>();
		List<Integer> oddArray = new ArrayList<Integer>();
		
		for(int num : arr) {
			if(num%2==0)
				evenArray.add(num);
			else
				oddArray.add(num);
		}
		
		System.out.println("Even Array: " + evenArray + " with Size: " + evenArray.size());
		System.out.println("Odd Array: " + oddArray + " with Size: " + oddArray.size());
	}
}

