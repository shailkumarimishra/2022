package ds_practice;

import java.util.Scanner;

public class checkKthSetBit {
	
	public static boolean isKthBitSet(int num,int k) {
		if(String.valueOf(Integer.toBinaryString(num)).length()<k)
			return false;
		return Integer.toBinaryString(num).charAt(k-1)=='1'?true:false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(isKthBitSet(num, k));
	}

}
