package datastructure.arrays;

/**
 * Implementing Array Data Structure with pre-defined size 10
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
public class MyArray {
	private static final int CAPACITY = 10;
	private int[] array;
	private int size;

	public MyArray() {
		this.array = new int[CAPACITY];
	}

	public void add(int data) {
		addLast(data);
	}

	public void addFirst(int data) {
		if (isFull()) {
			System.out.println("Array is Full !!");
			return;
		}
		for (int i = size - 1; i >= 0; i--) {
			array[i + 1] = array[i];
		}
		array[0] = data;
		size++;
	}

	public void addLast(int data) {
		if (isFull()) {
			System.out.println("Array is Full !!");
			return;
		}
		array[size++] = data;
	}

	public void add(int index, int data) {
		if (isFull()) {
			System.out.println("Array is Full !!");
			return;
		} else if (index == 0) {
			addFirst(data);
		} else if (index == size) {
			addLast(data);
		} else {
			for (int i = size - 1; i >= index; i--) {
				array[i + 1] = array[i];
			}
			array[index] = data;
			size++;
		}
	}

	public int remove(int data) {
		if (isEmpty()) {
			System.out.println("Array is Empty...");
			return -1;
		}
		int index=getIndex(data);
		int value = array[index];
		for (int i = index; i < size-1; i++) {
			array[i]=array[i+1];
		}
		size--;
		return value;
	}
	
	public int removeATIndex(int index) {
		if (isEmpty()) {
			System.out.println("Array is Empty...");
			return -1;
		}
		int value = array[index];
		for (int i = index; i < size-1; i++) {
			array[i]=array[i+1];
		}
		size--;
		return value;
	}

	private int getIndex(int data) {
		int value = 0;
		for (int i = 0; i < size; i++) {
			value = array[i];
			if (value == data) {
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
		int value = array[0];
		for (int i = 0; i < size; i++) {
			array[i] = array[i + 1];
		}
		size--;
		return value;
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
		for (int i=0;i<size;i++)
			System.out.print(array[i] + " ");
	}

	private boolean isEmpty() {
		return size == 0;
	}

	private boolean isFull() {
		return size == CAPACITY;
	}

}
