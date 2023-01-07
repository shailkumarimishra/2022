package dsa.arrays;

public class MyArrayList {
private static int DEFAULT_CAPACITY=5;
private int size;
private int[] array;


public MyArrayList() {
	this.array=new int[DEFAULT_CAPACITY];
}

/**
 * 1. check array is full or not
 * 2. if yes,
 * 	a) create a new array
 *  b)double the capacity
 *  c)copy the existing elements in new array
 *  d)update the array reference by new array
 * 3. else,
 *  a)store data at current index.
 * 4. increase the size by 1.
 * 
 * Average T.C:- O(1).
 * @param data
 */
public void add(int data) {
	if(isFull())
		copyElements();
	this.array[size++]=data;
}

/**
 * 1. check range 
 * 2. do shifting
 * 3. insert the data at given index
 * 4. increase the size by 1
 * @param index
 * @param data
 */
public void add(int index,int data) {
	if(index>=0 && index<size) {
		for(int i=size-1;i>=index;i--) {
			this.array[i+1]=this.array[i];
		}
		this.array[index]=data;
		size++;
	}
}

public int size() {
	return size;
}
private boolean isFull() {
	return size==DEFAULT_CAPACITY;
}

private void copyElements() {
	DEFAULT_CAPACITY=2*size;
	int[] temp=new int[DEFAULT_CAPACITY];
	for(int i=0;i<size;i++) {
		temp[i]=this.array[i];
	}
	this.array=temp;
}
public void display() {
	for(int i=0;i<size;i++) {
		System.out.print(this.array[i]+" ");
	}
}
}
