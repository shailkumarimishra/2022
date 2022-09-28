package ds_practice;

import java.util.Scanner;

public class HCFOfTwoNo {
	
	// T.C:- O(?) using recursive approach (using longest division method)
	public static int calculateHCFOfTwoNo(int num1, int num2) {
		if(num1==0)
			return num2;
		else if(num2==0)
			return num1; 
		else if(num1==num2)
			return num1;
		else if(num1<num2) {
			num1=num1+num2;
			num2=num1-num2;
			num1=num1-num2;
		}
		else if(num1%num2==0)
			return num2;
		else {
			int rem=num1%num2;
			num1=num2;
			num2=rem;
		}
			return calculateHCFOfTwoNo(num1, num2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input1 = sc.nextInt();
		int input2=sc.nextInt();
		System.out.println(calculateHCFOfTwoNo(input1, input2));
	}

}
