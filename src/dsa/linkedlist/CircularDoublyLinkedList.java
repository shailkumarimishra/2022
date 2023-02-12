package dsa.linkedlist;

public class CircularDoublyLinkedList {
	private Node first;
	private Node last;
	private int size;

	public void add(int data) {
		Node newNode = new Node(null, data, null);
		if(first==null) {
			first=newNode;
			first.next=newNode;
//			first.prev=newNode;
			last=newNode;
		}else {
			Node temp=last;
			last.next=newNode;
			last=newNode;
			last.prev=temp;
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
		if(temp.next==first) {
			System.out.print(temp.data+" ");
		}
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
