package ds_practice;

import java.util.Scanner;

public class ComputePowers {
	
	//T.C:- O(n) where n is the value of power Using Iterative approach 
	public static int calculatePowersApproach1(int num,int pow) {
		if(pow==0)
			return 1;
		int val=1;
		for(int i=0;i<pow;i++)
			val*=num;
		return val;
			
	}
	
	//T.C:- O(?) Using Math class
	public static int calculatePowersApproach2(int num,int pow) {
		return (int)Math.pow(num, pow);
			
	}
	
	//T.C:- O(n) where n is the value of power Using recursive approach
	public static int calculatePowersApproach3(int num,int pow) {
		if(pow==0)
			return 1;
		return num*calculatePowersApproach3(num, pow-1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int pow = sc.nextInt();
		System.out.println(calculatePowersApproach1(num, pow));
		System.out.println(calculatePowersApproach2(num, pow));
		System.out.println(calculatePowersApproach3(num, pow));
	}

}
