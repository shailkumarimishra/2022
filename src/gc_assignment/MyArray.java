package gc_assignment;

import java.util.Scanner;                    

public class MyArray  {

    private static final int SENTINEL = -999;  // Sentinel value used to indicate end of input
    private static final int DEFAULT_SIZE = 20;  // the default size to use if one is not specified
    private int[] arr; // Data member to reference an array of integers
    private int numElements; // the number of elements entered into the array
    private int sum;
    private int min;
    private int max;
    private double avg;
    private double med;
    
// CONSTRUCTORS
    // Initializes a MyArray object using default members
    public MyArray() {
       arr = new int[DEFAULT_SIZE];
       numElements = 0;
       sum=0;
       min=0;
       max=0;
       avg=0.0;
       med=0.0;
    }
    
    public MyArray(int n) {
    	if(n<0)
    		throw new NegativeArraySizeException();
    	 arr = new int[n];
         numElements = 0;
         sum=0;
         min=0;
         max=0;
         avg=0.0;
         med=0.0;
    }
    
    public MyArray(int[] arr) {
    	this.arr=new int[arr.length];
    	for(int i=0;i<arr.length;i++)
    		this.arr[i]=arr[i];
		if (isArrayEmpty(this.arr)) {
			numElements = 0;
			sum = 0;
			min = 0;
			max = 0;
			avg = 0.0;
			med = 0.0;
		}else {
			numElements = arr.length;
			computeStatistics();
		}
       
   }
   
    private boolean isArrayEmpty(int[] arr) {
    	for(int i=0;i<arr.length;i++) {
    		if(arr[i]!=0)
    			return false;
    	}
		return true;
	}

	public void inputElements() {
    	System.out.println("Enter upto 20 integers and -999 to end user input:");
    	Scanner sc=new Scanner(System.in);
    	while(sc.hasNext()) {
    		String next = sc.next();
    		if(next.equals("-999"))
    			break;
    		if(numElements<20)
    			this.arr[numElements++]=Integer.parseInt(next);
    	}
    	computeStatistics();
    }
	
	public String toString() {
		String result="";
		if(isArrayEmpty(arr)) {
			result=result+"["+"]";
		}else {
			result=result+"[";
			for(int i=0;i<numElements-1;i++) {
				result=result+arr[i]+",";
			}
			result=result+arr[numElements-1]+"]";
		}
		return result;
	}
	
	public void computeStatistics() {
		sum=fetchSumOfArray();
		min=fetchMinOfArray();
		max=fetchMaxOfArray();
		avg=fetchAvgOfArray(sum);
		med=fetchMedianOfArray();
	}
	
	public int numOccurences(int n) {
		int count=0;
		for(int a:arr) {
			if(a==n)
				count++;
		}
		return count;
	}
	
	public boolean insert(int n, int position) {
		if(!(position>=0 && position<numElements))
			return false;
		else if(numElements==this.arr.length) {
			return false;
		}else {
			for(int i=numElements-1;i>=position;i--) {
				arr[i+1]=arr[i];
			}
			arr[position]=n;
			numElements++;
			computeStatistics();
			return true;
		}
	}
	
	public boolean remove(int position) {
		if(!(position>=0 && position<numElements))
			return false;
		else {
			for(int i=position;i<numElements;i++) {
				arr[i]=arr[i+1];
			}
			numElements--;
			computeStatistics();
			return true;
		}
	}
	
	public boolean grow(int n) {
		if(n<0)
			throw new NegativeArraySizeException();
		else if(n==0)
			return false;
		else {
			int temp[]=new int[arr.length+n];
			for(int i=0;i<numElements;i++)
				temp[i]=arr[i];
			this.arr=temp;
			return true;
		}
	}
	
	

    public int[] getArr() {
		return arr;
	}

	public int getSum() {
		return sum;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public double getAvg() {
		return avg;
	}

	public double getMed() {
		return med;
	}

	private double fetchMedianOfArray() {
    	int [] temp=getSortedArray(this.arr);
    	if(numElements%2!=0)
    		return temp[numElements/2];
    	else {
    		int index1=numElements/2;
    		int index2=index1+1;
    		return (temp[index1]+temp[index2])/2;
    	}
	}

	private int[] getSortedArray(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int j=i;
			int a=arr[i];
			while((j>0)&&arr[j-1]>a) {
				arr[j]=arr[j-1];
				j--;
			}
			arr[j]=a;
		}
		return arr;
	}

	private double fetchAvgOfArray(int sum) {
    	return sum/numElements;
	}

	private int fetchMaxOfArray() {
    	int max=this.arr[0];
    	for(int i=1;i<numElements;i++) {
    		if(max<this.arr[i])
    			max=this.arr[i];
    	}
		return max;
	}

	private int fetchMinOfArray() {
    	int min=this.arr[0];
    	for(int i=1;i<numElements;i++) {
    		if(min>this.arr[i])
    			min=arr[i];
    	}
		return min;
	}

	private int fetchSumOfArray() {
    	int sum=0;
    	for(int a:this.arr)
    		sum=sum+a;
		return sum;
	}

	public static void main(String [] args) {

        System.out.println("\nUnit Test for MyArray.\n");

	// TBA
        
    }
}
