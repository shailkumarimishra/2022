package ds_practice;

import java.util.Scanner;

public class PrimeFactorsOfNo {
	
	//T.C:-O(?) using iterative approach
	public static void fetchPrimeFactors(int num) {
		if(isPrimeNo(num)) {
			System.out.print(num);
			return;
		}
		int dividend=num;
		int multiple=1;
		int i=2;
		while(multiple!=num) {
			if(dividend%i==0) {
				multiple*=i;
				if(multiple!=num) {
					dividend=dividend/i;
					System.out.print(i+" ");
				}else {
					System.out.print(i);
					return;
				}
			}else {
				i++;
			}
		}
			
	}

	private static boolean isPrimeNo(int num) {
		if(num == 0 || num == 1)
			return false;
		if(num==2)
			return true;
		for(int i=2;i<=num/2;i++) {
			if(num%i==0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		fetchPrimeFactors(input);
	}

}
