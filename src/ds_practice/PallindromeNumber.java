package ds_practice;

import java.util.Scanner;

public class PallindromeNumber {
	
	// T.C : O(1) using StringBuilder
	public static boolean isPallindromeNumberApproach1(int number) {
		String orgString = String.valueOf(number);
		StringBuilder builder = new StringBuilder(orgString);
		StringBuilder reversedSB = builder.reverse();
		String reverseString = reversedSB.toString();
		return orgString.equals(reverseString);
	}
	
	//T.C:- O(n) without using String
	public static boolean isPallindromeNumberApproach2(int number) {
		int orgNumber=number;
		int length=number==0?1:(int)Math.floor(Math.log10(number))+1;
		int placeValue = (int)Math.pow(10, length);
		int reverseNum=0;
		while(length-->0) {
			int reminder=number%10;
			number=number/10;
			placeValue=placeValue/10;
			reverseNum=reverseNum+reminder*placeValue;
		}
		return orgNumber==reverseNum;
	}
	
	// T.c:- O(n/2) using String while applying recursive approach
	public static boolean isPallindromeNumberApproach3(int number) {
		String str = String.valueOf(number);
		return checkPallindrome(str,0,str.length()-1);
	}

	private static boolean checkPallindrome(String str, int start, int end) {
		if(start>=end)
			return true;
		return ((str.charAt(start)==str.charAt(end)) && checkPallindrome(str, start+1, end-1));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
//		System.out.println(isPallindromeNumberApproach1(num));
//		System.out.println(isPallindromeNumberApproach2(num));
//		System.out.println(isPallindromeNumberApproach3(num));
	}

}
