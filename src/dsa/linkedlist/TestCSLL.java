package dsa.linkedlist;

public class TestCSLL {

	public static void main(String[] args) {
		CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
		csll.add(10);
		csll.add(20);
		csll.add(30);
		csll.add(40);
		csll.add(50);
		csll.display2();
		System.out.println();
//		csll.addFirst(100);
//		csll.display2();
//		System.out.println();
//		csll.add(4, 99);
//		csll.display2();
//		System.out.println();
		csll.delete(90);
		csll.display2();
		System.out.println();
	}

}
