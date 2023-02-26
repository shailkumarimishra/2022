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
	
	public void addFirst(int data) {
		if(first==null) {
			add(data);
			return;
		}
		Node newNode = new Node(data,null);
		newNode.next=first;
		first=newNode;
		last.next=first;
		size++;
	}
	
	public void addLast(int data) {
		add(data);
	}
	
	public void add(int index,int data) {
		if(index>=0 && index<size) {
			if(index==0) {
				addFirst(data);
			}else if(index==size-1) {
				addLast(data);
			}else {
				Node newNode = new Node(data,null);
				Node temp = first;
				for(int i=0;i<index-1;i++) {
					temp=temp.next;
				}
				newNode.next=temp.next;
				temp.next=newNode;
				size++;
			}
		}
	}
	
	public void delete(int data) {
		Node current = first;
		Node previous = first;
		
		//iterate to find out the position
		while(current!=last) {
			if(current.data==data) {
				break;
			}
			previous=current;
			current=current.next;
		}
		
		//delete
		if(size==1 && current.data==data) {//delete first element and size==1
			first=null;
			last=null;
			size--;
		}else if(size>1 && current==first) {//delete first element and size>1
			first=first.next;
			current.next=null;
			size--;
		}else if(size>1 && current!=last) {//delete mid element
			previous.next=current.next;
			current.next=null;
			size--;
		}else if(size>1 && current.data==data) {//delete last element
			previous.next=first;
			current.next=null;
			last=previous;
			size--;
		}
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
