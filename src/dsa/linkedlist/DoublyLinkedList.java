package dsa.linkedlist;

public class DoublyLinkedList {
	private Node first;
	private Node last;
	private int size;
	
	public void add(int data) {
		Node newNode = new Node(null, data, null);
		if (first == null) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			newNode.prev = last;
			last = newNode;
		}
		size++;
	}
	
	public void addFirst(int data) {
		if (first == null) {
			add(data);
			return;
		}
		Node newNode = new Node(null, data, null);
		newNode.next = first;
		first.prev = newNode;
		first = newNode;
		size++;
	}
	
	public void addLast(int data) {
		add(data);
	}
	
	public void add(int index, int data) {
		if (index >= 0 && index < size) {
			if (index == 0) {
				addFirst(data);
			} else if (index == size - 1) {
				addLast(data);
			} else {
				Node temp = first;
				Node newNode = new Node(null, data, null);
				for (int i = 0; i < index - 1; i++) {
					temp = temp.next;
				}
				newNode.next = temp.next;
				temp.next.prev = newNode;
				temp.next = newNode;
				newNode.prev = temp;
				size++;
			}
		}
	}
	
	public void delete(int data) {
		//check whether data is present or not
		int index = contains(data);
		if (index != -1) {
			//when only one element is present
			if (index == 0 && size == 0) {
				first = null;
				last = null;
			} else if (index == 0 && size != 0) {//when data is at index 0 and size>1
				first = first.next;
				first.prev.next = null;
				first.prev = null;
			} else if (index == size - 1) {//when data is the last element
				last = last.prev;
				last.next.prev = null;
				last.next = null;
			} else {
				Node temp = first;
				for (int i = 0; i < index; i++) {
					temp = temp.next;
				}
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				temp.prev = null;
				temp.next = null;
			}
			size--;
		}
	}
	
	//if data is not present it returns -1 else return the index at which data is present.
	public int contains(int data) {
		Node temp = first;
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (temp.data == data) {
				index = i;
				break;
			}
			temp = temp.next;
		}
		return index;
	}

	public void display() {
		Node temp = first;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	public void reverse() {
		Node temp = last;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.prev;
		}
	}
	
	public int size() {
		return size;
	}
	
	private class Node {
		Node prev;
		int data;
		Node next;

		public Node(Node prev, int data, Node next) {
			this.prev = prev;
			this.data = data;
			this.next = next;
		}

	}
}
