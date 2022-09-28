package ds_practice;

import java.util.Scanner;

public class PallindromeString {
	
	//T.C:- O(n) iterative approach
	public static void printPallindromeStringApproach1(int number) {
		int [] series=new int[number+1];
		for(int i=0;i<=number;i++) {
			if(i<2) {
				series[i]=i;
				System.out.print(series[i]+" ");
			}else {
				series[i]=series[i-1]+series[i-2];
				System.out.print(series[i]+" ");
			}
		}
	}
	
	//T.C:- O(n) recursive approach
	public static void printPallindromeStringApproach2(int number){
		printString(number,0,0,0);
	}
	
	private static void printString(int number, int prev, int next,int count) {
		if(number==0) {
			System.out.print(number+" ");
			return;
		}
		else if(count>number) {
			return;
		}
		else if(count==0||count==1) {
			System.out.print(count+" ");
			next=count;
		}
		else {
			next=prev+next;
			System.out.print(next+" ");
		}
		printString(number, next, prev, count+1);
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input=sc.nextInt();
		printPallindromeStringApproach1(input);
		System.out.println();
		printPallindromeStringApproach2(input);
	}

}
