package ds_practice;

import java.util.Scanner;

public class PowerOf2 {
	
	//Using log. T.C:- O(1) 
	public static boolean isPowerOf2Approach1(int num){
		double val=(int)Math.floor(Math.log10(num)/Math.log10(2));
		return (int)Math.pow(2, val)==num?true:false;
	}
	
	public static boolean isPowerOf2Approach2(int num){
		if(num==0)
			return false;
		while(num!=1) {
			if(num%2!=0)
				return false;
			num=num/2;
		}
		return true;
	}
	public static boolean isPowerOf2Approach3(int num){
		if(num==0)
			return false;
		while(num!=1) {
			if(num%2!=0)
				return false;
			num=num>>2;
		}
		return true;
	}
	public static boolean isPowerOf2Approach4(int num){
		return (num & (num-1))==0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println(isPowerOf2Approach1(input));
		System.out.println(isPowerOf2Approach2(input));
		System.out.println(isPowerOf2Approach3(input));
		System.out.println(isPowerOf2Approach4(input));
	}

}
