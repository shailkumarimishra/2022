package dsa.stack;

public class TwoStackInSingleArray {
private int[] array;
private int capacity;
private int top1;
private int top2;

public TwoStackInSingleArray(int capacity) {
	this.capacity = capacity;
	this.top1=-1;
	this.top2=this.capacity;
	this.array = new int[this.capacity];
}

public boolean push1(int data) {
	if(top1<top2-1) {
		top1++;
		this.array[top1]=data;
		return true;
	}
	return false;
}

public boolean push2(int data) {
	if(top1<top2-1) {
		top2--;
		this.array[top2]=data;
		return true;
	}
	return false;
}

public Integer pop1() {
	if(top1>=0) {
		return this.array[top1--];
	}
	return null;
}

public Integer pop2() {
	if(top2<this.capacity) {
		return this.array[top2++];
	}
	return null;
}

public int size1() {
	return top1+1;
}

public int size2() {
	return this.capacity-top2;
}

public static void main(String[] args) {
	TwoStackInSingleArray stack = new TwoStackInSingleArray(10);
	stack.push1(10);
	stack.push1(20);
	stack.push1(30);
	stack.push1(40);
	stack.push1(50);
	stack.push1(60);
	
	stack.push2(11);
	stack.push2(12);
	stack.push2(13);
	stack.push2(14);
	
//	System.out.println(stack.push1(70));
//	System.out.println(stack.push2(15));
//	int size1 = stack.size1();
//	for(int i=0;i<size1;i++)
//		System.out.print(stack.pop1()+" ");
	
	Integer i=0;
     while((i=stack.pop1())!=null) {
    	 System.out.print(i+" ");
     }
	
	
}
}
