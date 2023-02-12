package dsa.linkedlist;

public class CircularSinglyLinkedList {
	private Node first;
	private Node last;
	private int size;

	public void add(int data) {
		Node newNode = new Node(data, null);
		if(first==null) {
			first=newNode;
			first.next=first;
			last=first;
		}else {
			last.next=newNode;
			last=newNode;
			last.next=first;
		}
		size++;
	}
	
	public void display() {
		Node temp=first;
		while(temp!=null && temp.next!=first) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		if(temp.next==first)
			System.out.print(temp.data+" ");
	}
	
	public void display2() {
		Node temp=first;
		for(int i=0;i<size;i++) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

	private class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

	}
}
