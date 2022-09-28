package ds_practice;

import java.util.Scanner;

public class CountSetBits {
	
	//using Integer class. T.C:- O(1)
	public static int countBitsApproach1(int num) {
		return Integer.bitCount(num);
	}
	
	//using iterative approach T.C:- O(?)
	public static int countBitsApproach2(int num) {
		if(num==0||num==1) 
			return num;
		else if(num==2)
			return 1;
		int count=0;
		int base=2;
		int quo=num/2;
		do{
			quo=num/2;
			int rem=num%base;
			if(rem!=0)
				count++;
			num=quo;
		}while(quo>base);
		return count+1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println("Decimal "+input+" into Binary= "+Integer.toBinaryString(input));
		System.out.println(countBitsApproach1(input));
		System.out.println(countBitsApproach2(input));
		
	}

}
