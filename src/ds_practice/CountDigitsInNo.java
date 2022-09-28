package ds_practice;

import java.util.Scanner;

public class CountDigitsInNo {
	
	// T.C : O(n) ; n is  no. of digits in a number  (Iterative approach)
	public static int countDigitsApproach1(int number) {
		int count=0;
		int quotient=number/10;
		while(quotient>0) {
			count++;
			quotient=quotient/10;
		}
		return count+1;
	}
	
	// T.C : O(1) using String
	public static int countDigitsApproach2(int number) {
		return String.valueOf(number).length();
	}
	
	// T.C : O(1)
	public static int countDigitsApproach3(int number) {
		return number==0 ? 1 : (int)Math.floor(Math.log10(number))+1;
	}
	
	// T.C : O(n) using Recursion Approach
	public static int countDigitsApproach4(int number) {
		return getLength(number,1);
	}

	private static int getLength(int number, int i) {
		if(number/10==0) {
			return i;
		}
		return getLength(number/10, ++i);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
//		System.out.println(countDigitsApproach1(num));
//		System.out.println(countDigitsApproach2(num));
//		System.out.println(countDigitsApproach3(num));
		System.out.println(countDigitsApproach4(num));
	}

}
