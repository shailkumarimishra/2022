package datastructure.arrays;

/**
 * Implementing Array Data Structure where array size increases by twice the previous size once array gets full.
 * 
 * operations:
 * 1. add/addLast
 * 2. addFirst
 * 3. add at particular index
 * 4. remove/Last
 * 5. removeFirst
 * 6. remove at particular index
 * 7. display
 * 8. contains
 * 9. size
 * 10.isEmpty
 * 11.isFull
 * 
 * @author Shail Mishra
 *
 */
public class MyDynamicArray {
	private   int capacity = 10;
	private int[] array;
	private int size;

	public MyDynamicArray() {
		this.array = new int[capacity];
	}

	public void add(int data) {
		addLast(data);
	}

	public void addFirst(int data) {
		if (isFull()) {
			growArray();
		}
		rightShiftArrayElements();
		array[0] = data;
		size++;
	}

	private void rightShiftArrayElements() {
		for (int i = size - 1; i >= 0; i--) {
			array[i + 1] = array[i];
		}
	}

	private void growArray() {
		capacity=2*capacity;
		int[] temp=new int[capacity];
		for(int i=0;i<array.length;i++)
			temp[i]=array[i];
		array=temp;
	}

	public void addLast(int data) {
		if (isFull()) {
			growArray();
		}
		array[size++] = data;
	}

	public void add(int index, int data) {
		if (!isValidIndex(index)) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			addFirst(data);
		} else if (index == size) {
			addLast(data);
		} else {
			if(array.length==size)
				growArray();
			for (int i = size-1; i > index; i--) {
				array[i+1] = array[i];
			}
			array[index] = data;
			size++;
		}
	}

	private boolean isValidIndex(int index) {
		return index>=0 && index<=size;
	}

	public int remove(int data) {
		if (isEmpty()) {
			System.out.println("Array is Empty...");
			return -1;
		}
		int index=getIndexOf(data);
		leftShiftArrayElements(index);
		size--;
		return data;
	}

	private void leftShiftArrayElements(int index) {
		for (int i = index; i < size-1; i++) {
			array[i]=array[i+1];
		}
	}
	
	public int removeATIndex(int index) {
		if (isEmpty()) {
			System.out.println("Array is Empty...");
			return -1;
		}else if(!isValidIndex(index)) {
			throw new IndexOutOfBoundsException();
		}
		leftShiftArrayElements(index);
		size--;
		return getValueAt(index);
	}

	public int getIndexOf(int data) {
		for (int i = 0; i < size; i++) {
			if (array[i] == data) {
				return i;
			}
		}
		return -1;
	}

	public int removeFirst() {
		if (isEmpty()) {
			System.out.println("Array is Empty...");
			return -1;
		}
		for (int i = 0; i < size; i++) {
			array[i] = array[i + 1];
		}
		size--;
		return array[0];
	}

	public int removeLast() {
		if (isEmpty()) {
			System.out.println("Array is Empty...");
			return -1;
		}
		int value = array[size - 1];
		size--;
		return value;
	}

	public boolean contains(int data) {
		for (int i=0;i<size;i++) {
			if (array[i] == data)
				return true;
		}
		return false;
	}

	public int size() {
		return size;
	}

	public void display() {
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<size;i++) {
			sb.append(array[i]);
			if(i!=size-1)
				sb.append(",");
		}
		System.out.println("["+sb.toString()+"]");
	}

	private boolean isEmpty() {
		return size == 0;
	}

	private boolean isFull() {
		return size == capacity;
	}
	
	public int getValueAt(int index) {
		if(!isValidIndex(index))
			throw new IndexOutOfBoundsException();
		return array[index];
	}
	
}
