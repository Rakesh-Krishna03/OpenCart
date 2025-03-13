package javaPrograms;

public class ArrayPalindrome {

	public static void main(String[] args) {

		int arr[] = { 1, 6, 6, 1 };

		if (isArrayPalindrome(arr))
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");
	}

	public static boolean isArrayPalindrome(int arr[]) {
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			if (arr[left] != arr[right])
				return false;

			left++;
			right--;
		}
		return true;
	}
}
