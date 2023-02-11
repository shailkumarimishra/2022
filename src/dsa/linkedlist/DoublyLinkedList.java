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
	
	class Node {
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
