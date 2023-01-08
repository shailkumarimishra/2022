package dsa.arrays;

public class GenericArrayList<T> {
	private static int DEFAULT_CAPACITY=5;
	private int size;
	private Object[] array;
	
	public GenericArrayList() {
		this.array=new Object[DEFAULT_CAPACITY];
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
	public void add(T data) {
		if(isFull())
			copyElements();
		this.array[size++]=data;
	}
	
	private boolean isFull() {
		return size==DEFAULT_CAPACITY;
	}

	private void copyElements() {
		DEFAULT_CAPACITY=2*size;
		Object[] temp=new Object[DEFAULT_CAPACITY];
		for(int i=0;i<size;i++) {
			temp[i]=this.array[i];
		}
		this.array=temp;
	}
	
	public T get(int index) {
		if(!(index>=0 && index<size)) {
			throw new RuntimeException("Index is out of Range");
		}
		return (T)this.array[index];
	}
	
	public Object[] getAll() {
		return this.array;
	}
}
