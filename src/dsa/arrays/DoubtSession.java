package dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class DoubtSession {
	
	//Q5.find max diff in the given array. I/O:- int[] arr={2,3,10,6,4,8,1}; O/P:- 8 where j>i and i,j are indices.
	//T.C: O(n2) 
public static int getMax(int[] arr) {
	int max=arr[1]-arr[0];
	for(int i=0;i<arr.length;i++) {
		for(int j=i+1;j<arr.length-1;j++) {
			max=Math.max(max, arr[j]-arr[i]);
		}
	}
	return max;
}

//T.C: O(n)
public static int getMaxEfficient(int[] arr) {
	int max=arr[1]-arr[0];
	int min=arr[0];
	for(int i=1;i<arr.length;i++) {
		max=Math.max(max, arr[i]-min);
		min=Math.min(min, arr[i]);
	}
	return max;
}

//Q6.find leaders in the given array. I/O:- int[] arr={7,10,4,10,6,5,2}; O/P:- 10 6 5 2
//T.C:-O(n2)
public static void printLeaders(int[] arr) {
	for(int i=0;i<arr.length;i++) {
		boolean flag=true;
		for(int j=i+1;j<arr.length;j++) {
			if(arr[i]<=arr[j]) {
				flag=false;
				break;
			}
		}
		if(flag)
			System.out.print(arr[i]+" ");
	}
}	

public static void printLeadersEfficient(int[] arr) {
	int currentLeader=arr[arr.length-1];
	List<Integer> result=new ArrayList<Integer>();
	result.add(currentLeader);
	for(int i=arr.length-2;i>=0;i--) {
		if(currentLeader<arr[i]) {
			currentLeader=arr[i];
			result.add(currentLeader);
		}
	}
	System.out.println(result);
}

public static void main(String[] args) {
	int[] arr5={10,1,2,6,4,8,1};
	System.out.println("max element = "+getMaxEfficient(arr5));
	int[] arr6={7,10,4,10,6,5,2};
	printLeadersEfficient(arr6);
}
}
