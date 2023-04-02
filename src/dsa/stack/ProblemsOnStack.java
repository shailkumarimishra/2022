package dsa.stack;

import java.util.Stack;

public class ProblemsOnStack {
	/**
	 * closest greatest
	 * I/P:- 15 10 18 12  4  6 2  8
	 * O/P:- -1 15 -1 18 12 12 6 12
	 * T.C:-O(n)
	 */
 public void printPrevGreatest(int[] arr) {
	 Stack<Integer> stack = new Stack<>();
	 stack.push(arr[0]);
	 System.out.print(-1+" ");
	 for(int i=1;i<arr.length;i++) {
		 while(!stack.isEmpty() && stack.peek()<=arr[i]) {
			 stack.pop();
		 }
		int pg= stack.isEmpty() ? -1:stack.peek();
		System.out.print(pg+" ");
		stack.push(arr[i]);
	 }
 }
 
 public void printNextGreatest(int[] arr) {
	 
 }
 
 public static void main(String[] args) {
	ProblemsOnStack stack =new ProblemsOnStack();
	int[] arr= {15, 10, 18, 12,  4,  6, 2,  8};
	stack.printPrevGreatest(arr);
}
}
