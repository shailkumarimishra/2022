package ds_practice;

import java.util.Scanner;

public class Factorial {
	
	//T.C:- O(n) using Recursive approach
	public static int factorialApproach1(int num) {
		if(num==0)
			return 1;
		return num*factorialApproach1(num-1);
	}
	
	//T.C:- O(n) using iterative approach
	public static int factorialApproach2(int num) {
		int fact=1;
		for(int i=num;i>0;i--)
			fact=fact*i;
		return fact;
			
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input=sc.nextInt();
		System.out.println(factorialApproach1(input));
		System.out.println(factorialApproach2(input));
	}
}
