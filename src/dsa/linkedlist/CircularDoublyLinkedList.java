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
			first.prev=newNode;
			last=newNode;
		}else {
			Node temp=last;
			last.next=newNode;
			last=newNode;
			last.prev=temp;
			last.next=first;
			first.prev=last;
		}
		size++;
	}
	
	public void addFirst(int data) {
		if(first==null) {
			add(data);
			return;
		}
		Node newNode = new Node(null,data,null);
		newNode.next=first;
		first.prev=newNode;
		newNode.prev=last;
		last.next=newNode;
		first=newNode;
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
				Node newNode = new Node(null,data,null);
				Node temp=first;
				for(int i=0;i<index-1;i++) {
					temp=temp.next;
				}
				newNode.next=temp.next;
				temp.next.prev=newNode;
				temp.next=newNode;
				newNode.prev=temp;
				size++;
			}
		}
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
	
	public void delete(int data) {
		Node temp=first;
		
		//iterate to find out the position 
		while(temp!=last) {
			if(temp.data==data) {
				break;
			}
			temp=temp.next;
		}
		
		//delete
		if(size==1 && temp.data==data) {// delete first element and size==1
			first=null;
			last=null;
			size--;
		}else if(size>1 && temp==first) {// delete first element and size>1
			first=first.next;
			first.prev=last;
			last.next=first;
			temp.next=null;
			temp.prev=null;
			size--;
		}else if(size>1 && temp!=last) {// delete mid element
			temp.prev.next=temp.next;
			temp.next.prev=temp.prev;
			temp.prev=null;
			temp.next=null;
			size--;
		}else if(size>1 && temp.data==data) {// delete last element
			last=last.prev;
			last.next=first;
			first.prev=last;
			temp.next=null;
			temp.prev=null;
			size--;
		}
	}
	
	public void display2() {
		Node temp=first;
		for(int i=0;i<size;i++) {
			System.out.print(temp.data+" ");
			temp=temp.next;
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
