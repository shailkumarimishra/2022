package ds_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DivisiorsOfNo {
	
	//T.C:- O(?) using iterative approach
	public static Set<Integer> allDivisorsOfNo(int num) {
		Set<Integer> divisors=new HashSet<>();
		divisors.add(1);
		//check no is prime or not
		if(isPrimeNo(num)) {
			divisors.add(num);
			return divisors;
		}
		for(int i=2;i<=num/2;i++) {
			if(num%i==0) {
				divisors.add(i);
				divisors.add(num/i);
			}
		}
		divisors.add(num);
		return divisors;
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
		Set<Integer> result = allDivisorsOfNo(input);
		List<Integer> list = new ArrayList<>(result);
		Collections.sort(list);
//		list.forEach(System.out::println);
		list.forEach(i->System.out.print(i+" "));
	}

}
