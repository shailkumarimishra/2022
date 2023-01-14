package dsa.arrays;

public class ProblemPractice {
//Q1. check given array is sorted or not?(assume in ascending order)
	public static boolean isSorted(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]>arr[i+1])
				return false;
		}
		return true;
	}
//Q2. reverse a given array
	public static int[] reverse(int[] arr) {
		int[] temp=new int[arr.length];
		for(int i=arr.length-1,j=0;i>=0;i--,j++)
			temp[j]=arr[i];
		return temp;
	}
	
	public static int[] efficientReverse(int[] arr) {
		int low=0;
		int high=arr.length-1;
		while(low<high) {
			int temp=arr[low];
			arr[low]=arr[high];
			arr[high]=temp;
			low++;
			high--;
		}
		
		return arr;
	}
	
//Q3.move all zero's to end of the given array. I/O:- int[] arr={10,0,0,8,0,5,0}; O/P:- int[] arr={10,8,5,0,0,0,0}
	public static int[] moveZeroToEnd(int[] arr) {
		int[] temp=new int[arr.length];
		int start=0;
		int end=arr.length-1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				temp[end--]=arr[i];
			}else {
				temp[start++]=arr[i];
			}
		}
		return temp;
	}
	
	public static int[] efficientMoveZeroToEnd(int[] arr) {
		//count for non-zero
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				int temp=arr[i];
				arr[i]=arr[count];
				arr[count]=temp;
				count++;
			}
		}
		return arr;
	}
	
	//Q4. left rotate a given array by d{any positive Integer}
	public static int[] leftRotate(int[] arr,int d) {
		//
		int[] temp=new int[d];
		for(int i=0;i<d;i++)
			temp[i]=arr[i];
		for(int i=d;i<arr.length;i++)
			arr[i-d]=arr[i];
		for(int i=0;i<d;i++)
			arr[arr.length-d+i]=temp[i];
		return arr;
	}
	
	//Q5.find max diff in the given array. I/O:- int[] arr={2,3,10,6,4,8,1}; O/P:- 8
//	public static int maxDiff(int[] arr) {
		
//	}
	
	//Q5.find leaders in the given array. I/O:- int[] arr={7,10,4,10,6,5,2}; O/P:- 10 6 5 2
		public static String findLeaders(int[] arr) {
			String leaders="";
			for(int i=0;i<arr.length-1;i++) {
				if(arr[i+1]<arr[i])
					if(!leaders.contains(String.valueOf(arr[i])))
					leaders+=arr[i]+" ";
			}
			leaders+=arr[arr.length-1];
			return leaders;
		}
		
		public static int[] findLeadersV2(int[] arr) {
			int index=0;
			int num=-1;//considering arr's of positive no.
			int lastnum=-1;
			
			for(int i=0,j=arr[arr.length-1];i<arr.length-1;i++) {
				if (arr[i] > arr[i + 1] && num != arr[i]) {
					int temp = arr[i];
					arr[i] = arr[index];
					arr[index++] = temp;
					num = temp;
				}
				lastnum= j==num ? 0:-1;
			}
			if(lastnum==-1)
				index+=1;
			
			int [] result=new int[index];
			for(int i=0;i<=index;i++) {
				if(i==index-1) {
					result[i]=arr[arr.length-1];
					break;
				}
				result[i]=arr[i];
			}
			return result;
		}
	
	public static void main(String[] args) {
		int[] arr= {10,20,30,40,50,60};
		int[] result = efficientReverse(arr);
		for(int i:result)
			System.out.print(i+" ");
		
		int[] arr2={10,0,0,8,0,5,0};
		int[] result2 = efficientMoveZeroToEnd(arr2);
		System.out.println();
		for(int i:result2)
			System.out.print(i+" ");
		
		int[] arr3={1,2,3,4,5};
		int[] result3 = leftRotate(arr3,2);
		System.out.println();
		for(int i:result3)
			System.out.print(i+" ");
		
		int[] arr4={1,1,0,0,3,4};
		System.out.println();
		System.out.println("is array sorted = "+isSorted(arr4));
		
		int[] arr5={2,3,10,6,4,8,1};
//		System.out.println("max element = "+maxDiff(arr5));
		
		int[] arr6={7,10,4,10,6,5,2};
		System.out.println("leader elements = "+findLeaders(arr6));
		
		int[] result7 = findLeadersV2(arr6);
		System.out.println();
		for(int i:result7)
			System.out.print(i+" ");
	}
}
