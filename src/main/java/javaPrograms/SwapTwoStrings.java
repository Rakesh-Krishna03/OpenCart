package javaPrograms;

public class SwapTwoStrings {

	public static void main(String[] args) {
		
		String str1 = "Rakesh";
		String str2 = "Kumar";
		
		String temp = "Kumar";
		str2 = str1;
		str1 = temp;
		
		System.out.println(str1);
		System.out.println(str2);
		
//		------------------------------------------------------ //
		
		String R = "Rama";
		String K = "Krishna";
		
		R = R + K;
		K = R.substring(0, R.length() - K.length() );
		R = R.substring(K.length());
		System.out.println(R);
		System.out.println(K);
	}
}
