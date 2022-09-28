package ds_practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class LCMOf2No {
	
	//T.C:- O(?) using iterative approach
	public static int lcmApproach1(int num1,int num2) {
		if(isPrimeNo(num1) && isPrimeNo(num2)) {
			return num1*num2;
		}
		Map<Integer, Integer> pfOfnum1 = null;
		Map<Integer, Integer> pfOfnum2 = null;
		pfOfnum1 = getPrimeFactAndItsOccurence(num1);
		pfOfnum2 = getPrimeFactAndItsOccurence(num2);
		int lcm=1;
		for(Entry<Integer, Integer> entry1:pfOfnum1.entrySet()) {
			if(pfOfnum2.containsKey(entry1.getKey())) {
				Integer val1 = entry1.getValue();
				Integer val2 = pfOfnum2.get(entry1.getKey());
				lcm = val1>=val2 ? lcm*(int)Math.pow(entry1.getKey(), val1) : lcm*(int)Math.pow(entry1.getKey(), val2);
			}else {
				lcm=lcm*(int)Math.pow(entry1.getKey(), entry1.getValue());
			}
		}
		for(Entry<Integer, Integer> entry2:pfOfnum2.entrySet()) {
			if(!pfOfnum1.containsKey(entry2.getKey())) {
				lcm=lcm*(int)Math.pow(entry2.getKey(), entry2.getValue());
			}
		}
		return lcm;
		
	}
	
	//Using Relationship b/w LCM & HCF of 2 numbers i.e; num1*num2 = lcm*hcf
	@SuppressWarnings("static-access")
	public static int lcmApproach2(int num1,int num2) {
		int hcf = new HCFOfTwoNo().calculateHCFOfTwoNo(num1, num2);
		return (num1*num2)/hcf;
	}

	private static Map<Integer, Integer> getPrimeFactAndItsOccurence(int num) {
		Map<Integer, Integer> factors = new HashMap<>();
		if(isPrimeNo(num)) {
			factors.put(num, 1);
			return factors;
		}
		int dividend=num;
		int multiple=1;
		int i=2;
		int count=1;
		while(multiple!=num) {
			if(dividend%i==0) {
				multiple*=i;
				if(multiple!=num) {
					dividend=dividend/i;
					if(factors.containsKey(i)) {
						factors.replace(i, count, ++count);
					}else {
						factors.put(i, count);
					}
				}else {
					if(factors.containsKey(i)) {
						factors.replace(i, count, ++count);
					}else {
						factors.put(i, count);
					}
					return factors;
				}
			}else {
				i++;
				count=1;
			}
		}
		return factors;
		
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
		int input1 = sc.nextInt();
		int input2 = sc.nextInt();
		System.out.println(lcmApproach1(input1, input2));
		System.out.println(lcmApproach2(input1, input2));
	}

}
