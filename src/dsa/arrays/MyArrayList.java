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
 * 1. check range if yes then go to step 2 else go to step 6
 * 2. check whether array is full or not if yes only then,
 * 	a) create a new array
 *  b)double the capacity
 *  c)copy the existing elements in new array
 *  d)update the array reference by new array
 * 3. do shifting
 * 4. insert the data at given index
 * 5. increase the size by 1
 * 6. if index is not in range then throw ArrayIndexOutOfBoundsException.
 * @param index
 * @param data
 */
public void add(int index,int data) {
	if(index>=0 && index<size) {
		
		if( isFull())
			copyElements();
		
		for(int i=size-1;i>=index;i--) {
			this.array[i+1]=this.array[i];
		}
		
		this.array[index]=data;
		size++;
		
	}else
		throw new ArrayIndexOutOfBoundsException("Index out of range");
}

/**
 * 1. check whether array is empty 
 * 2. if yes then throw ArrayIndexOutOfBoundsException
 * 3. else check range
 * 4. do shifting
 * 5. decrease the size 
 * @param index
 */
public void deleteByIndex(int index) {
	if(index>=0 && index<size) {
		for(int i=index;i<size-1;i++) {
			this.array[i]=this.array[i+1];
		}
		size--;
	}else
		throw new ArrayIndexOutOfBoundsException("Index out of range");
}

/**
 * 1. check whether array is empty
 * 2. if yes then throw ArrayIndexOutOfBoundsException
 * 3. else check the data
 * 4. return index of the data
 * 5. if data doesn't match with list then return -1.
 * @param data
 * @return if data doesn't match with list then return -1 else return index of the data
 */
public int contains(int data) {
	for(int i=0;i<size;i++) {
		if(data==this.array[i])
			return i;
	}
	return -1;
}

/**
 * 1. check whether data is present
 * 2. if present then delete the data
 * 3. decrease the size.
 * @param data
 */
public void deleteByData(int data) {
	int index=contains(data);
	if(index!=-1) {
		deleteByIndex(index);
	}else
		System.out.println("data "+data+" not found!!");
}

/**
 * 
 * @return the size of Array
 */
public int size() {
	return size;
}

/**
 * 
 * @return true if array is full else false
 */
private boolean isFull() {
	return size==DEFAULT_CAPACITY;
}

/**
 * 
 * @return true if array is empty else false
 */
private boolean isEmpty() {
	return size==0;
}

/**
 * 	1. create a new array
 *  2. double the capacity
 *  3. copy the existing elements in new array
 *  4. update the array reference by new array
 */
private void copyElements() {
	DEFAULT_CAPACITY=2*size;
	int[] temp=new int[DEFAULT_CAPACITY];
	for(int i=0;i<size;i++) {
		temp[i]=this.array[i];
	}
	this.array=temp;
}

/**
 * 	displays the list 
 */
public void display() {
	for(int i=0;i<size;i++) {
		System.out.print(this.array[i]+" ");
	}
}
}
