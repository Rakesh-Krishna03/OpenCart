package javaPrograms;

public class ArraySumOfElements {
	
	public static void main(String[] args) {
		
		int[] arr = {4, 24, 4};
		
		int sum = 0;
		for(int i = 0; i<arr.length;i++) {
			 sum += arr[i];
		}
		
		System.out.println(sum);
		
		char[] str = {'r', 'a', 'k', 'i'};
		
		// =============== //
		
		String sumChar = "";
		
		for(int j = 0; j < str.length; j++) {
			sumChar += str[j];
		}
		
		System.out.println(sumChar);
		
	}		
}
