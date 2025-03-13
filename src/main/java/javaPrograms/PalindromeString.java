package javaPrograms;

public class PalindromeString {
	public static void main(String[] args) {
		String str = "MadAm";
		
		// Using While loop
		if (isPalindrome(str))
			System.out.println("Palindrom");
		else
			System.out.println("Not Palindrome");

		// Using StringBuilder Class
		if (isPalin(str))
			System.out.println("Palindrom");
		else
			System.out.println("Not Palindrome");
	}

	public static boolean isPalindrome(String str) {
		str = str.toLowerCase();
		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

	static boolean isPalin(String str) {

		str = str.toLowerCase();
		StringBuilder reverse = new StringBuilder(str).reverse();
		return str.equalsIgnoreCase(reverse.toString());
	}

}
