package ds_practice;

import java.util.Scanner;

public class FindEvenOddNo {
	public static boolean isEvenApproach1(int num) {
		return num%2==0;
	}
	public static boolean isEvenApproach2(int num) {
		return (num&1)==0?true:false;
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println(isEvenApproach1(input));
		System.out.println(isEvenApproach2(input));
	}

}
