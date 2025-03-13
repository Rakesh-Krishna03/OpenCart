package javaPrograms;


public class ArrayMinimumMaximum {

	public static void main(String[] args) {
		
		int[] arr = { 5, 8, 3, 4, 999, 2};
		int min = arr[0];
		int max = arr[0];
		
		for(int num: arr) {
			if(num < min)
			{
				min = num;
			}
			if(num > max)
			{
				max = num;
			}
		
		}
		System.out.println(min);
		System.out.println(max);
	}
}