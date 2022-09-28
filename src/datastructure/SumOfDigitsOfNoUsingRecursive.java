package datastructure;

import java.util.Scanner;

public class SumOfDigitsOfNoUsingRecursive {
	
	public static int fun(int num) {
		if(num==0)
			return 0;
		return num%10+fun(num/10);
	}
	//Q2. sum of alternate digits of a number
	public static int sumOfAlternateDigits(int num) {
		return findSum(num,0);
	}
	
	private static int findSum(int num, int count) {
		String str= String.valueOf(num);
		int digit=0;
		if(str.length()==1) {
			return num;
		}
		if(count==str.length()) {
			return 0;
		}
		if(count%2!=0)
			digit = Integer.parseInt(String.valueOf(str.charAt(count)));
		return digit+findSum(num, count+1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input=sc.nextInt();
		System.out.println(fun(input));
		System.out.println(sumOfAlternateDigits(input));
	}


}
