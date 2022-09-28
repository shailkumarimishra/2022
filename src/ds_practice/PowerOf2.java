package ds_practice;

import java.util.Scanner;

public class PowerOf2 {
	
	//Using log. T.C:- O(1) 
	public static boolean isPowerOf2(int num){
		double val=(int)Math.floor(Math.log10(num)/Math.log10(2));
		return (int)Math.pow(2, val)==num?true:false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println(isPowerOf2(input));
	}

}
