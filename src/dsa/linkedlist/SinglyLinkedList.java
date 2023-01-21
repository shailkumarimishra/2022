package dsa.linkedlist;

public class SinglyLinkedList {
private Node first;
private Node last;

//T.C:- O(1)
public void add(int data) {
	//create new node
	Node newNode = new Node(data, null);
	if(first==null) {
		first=newNode;
		last=newNode;
	}else {
		last.next=newNode;
		last=newNode;
	}
}

public void addFirst(int data) {
	//create new node
	Node newNode = new Node(data, null);
	newNode.next=first;
	first=newNode;
}

public void addLast(int data) {
	add(data);
}

public void add(int index,int data) {
	Node temp=first;
	Node newNode = new Node(data, null);
	
	for(int i=0;i<index-1;i++) {
		temp=temp.next;
	}
	newNode.next=temp.next;
	temp.next=newNode;
	
	
	
}

public void display() {
	Node temp=first;
	while(temp!=null) {
		System.out.print(temp.data+" ");
		temp=temp.next;
	}
}

private class Node{
	int data;
	Node next;
	
	public Node(int data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}
	
}
}
