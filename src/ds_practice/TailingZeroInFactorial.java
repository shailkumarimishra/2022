package ds_practice;

import java.util.Scanner;

public class TailingZeroInFactorial {
	
	//T.C:- O(?) using Recursive Approach 
	public static int countTrailingZeros(int num) {
		return calculateTrailingZeros(num,1);
	}
	
	private static int calculateTrailingZeros(int num,int pow) {
		int countZero=0;
		int base=(int)Math.pow(5, pow);
		if(num<base)
			return 0;
		countZero=(int) Math.floor(num/base);
		return countZero+calculateTrailingZeros(num,pow+1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input=sc.nextInt();
		System.out.println(countTrailingZeros(input));
	}

}
