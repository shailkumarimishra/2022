package datastructure;

import java.util.Scanner;

public class FirstNNumberSum {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		int sum=(num*(num+1))/2;
		System.out.println(sum);
	}

}
