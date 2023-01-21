package dsa.linkedlist;

public class TestSLL {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.add(10);
		sll.add(20);
		sll.add(30);
		sll.add(40);
		sll.add(50);
		sll.display();
		System.out.println();
		sll.addFirst(60);
		sll.display();
		System.out.println();
		sll.addLast(70);
		sll.display();
		System.out.println();
		sll.add(1, 90);
		sll.display();
	}

}
