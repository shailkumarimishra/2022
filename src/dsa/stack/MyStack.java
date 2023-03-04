package dsa.stack;

import dsa.arrays.MyArrayList;

// stack using array
public class MyStack {
	private int size;
	private MyArrayList list = new MyArrayList();

	public void push(int data) {
		list.add(data);
		size++;
	}

	public int peek() {
		return list.get(size - 1);
	}

	public void pop() {
		list.deleteByIndex(size - 1);
		size--;
	}

	public void display() {
		for (int i = size - 1; i >= 0; i--) {
			System.out.print(list.get(i) + " ");
		}
	}
}
