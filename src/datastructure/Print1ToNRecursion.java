package datastructure;

public class Print1ToNRecursion {
	//print N to 1 using recursion. Note:- T.C: O(n) where n is the upper limit
	public static void funNTo1(int n) {
		if(n==0)
			return;
		System.out.print(n+" ");
		funNTo1(n-1);
	}
	
	//print 1 to N using recursion. Note:- T.C: O(n) where n is the upper limit
	public static void fun1ToNApproach1(int n) {
		if(n==0)
			return;
		fun1ToNApproach1(n-1);
		System.out.print(n+" ");
	}
	
	public static void main(String[] args) {
		funNTo1(4);
		System.out.println();
		fun1ToNApproach1(4);
		System.out.println();
	}

}
