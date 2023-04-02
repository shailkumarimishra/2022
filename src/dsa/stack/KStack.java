package dsa.stack;

public class KStack {
private int[] array,top,next;
private int freeTop,k,capacity;

public KStack(int k, int capacity) {
	this.k = k;
	this.capacity = capacity;
	this.array = new int[capacity];
	this.top=new int[k];
	this.next=new int[capacity];
	
	//all k stacks are initially empty so top[i]=-1
	for(int i=0;i<k;i++) {
		this.top[i]=-1;
	}
	
	for(int i=0;i<capacity-1;i++) {
		this.next[i]=i+1;
	}
	this.next[capacity-1]=-1;
}

public boolean isEmpty(int sn) {
	return top[sn]==-1;
}

public boolean isFull() {
	return freeTop ==-1;
}

public void push(int data,int sn) {
	if(isFull()) {
		return;
	}
	//order is important
	int i=freeTop;
	freeTop=next[i];
	next[i]=top[sn];
	top[sn]=i;
	array[i]=data;
}

public int pop(int sn) {
	if(isEmpty(sn))
		return Integer.MAX_VALUE;
	int i = top[sn];
	top[sn]=next[i];
	next[i]=freeTop;
	return array[i];
}

public static void main(String[] args) {
	KStack stack = new KStack(3, 10);
	stack.push(10, 0);
	stack.push(20, 0);
	stack.push(30, 0);
	
	
	stack.push(91, 1);
	stack.push(92, 1);
	
	stack.push(81, 2);
	stack.push(82, 2);
	stack.push(83, 2);
	
	stack.push(40, 0);
	stack.push(50, 0);
	stack.push(60, 0);
	
	System.out.println("popped from stack 0: "+stack.pop(0));
	System.out.println("popped from stack 1: "+stack.pop(1));
	System.out.println("popped from stack 2: "+stack.pop(2));
	System.out.println("---------------------------------------");
	
	System.out.println("popped from stack 0: "+stack.pop(0));
	System.out.println("popped from stack 1: "+stack.pop(1));
	System.out.println("popped from stack 2: "+stack.pop(2));
	System.out.println("---------------------------------------");
	
	System.out.println("popped from stack 0: "+stack.pop(0));
	System.out.println("popped from stack 1: "+stack.pop(1));
	System.out.println("popped from stack 2: "+stack.pop(2));
	System.out.println("---------------------------------------");
	
}
}
