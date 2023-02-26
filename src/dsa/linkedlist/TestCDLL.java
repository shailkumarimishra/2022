package dsa.linkedlist;

public class TestCDLL {

	public static void main(String[] args) {
		CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();
		cdll.add(10);
		cdll.add(20);
		cdll.add(30);
		cdll.add(40);
		cdll.add(50);
		cdll.display2();
		System.out.println();
//		cdll.addFirst(100);
//		cdll.display();
//		System.out.println();
//		cdll.add(4, 99);
//		cdll.display2();
//		System.out.println();
		cdll.delete(50);
		cdll.display2();
		System.out.println();
	}

}
