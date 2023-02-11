package dsa.linkedlist;

public class TestDLL {

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.add(10);
		dll.add(20);
		dll.add(30);
		dll.add(40);
		dll.add(50);
		dll.display();
		System.out.println();
		dll.reverse();
		System.out.println();
		System.out.println(dll.size());
//		dll.addFirst(80);
//		dll.display();
//		System.out.println();
		dll.add(2, 90);
		dll.display();
		System.out.println();
		System.out.println(dll.size());
		dll.delete(90);
		dll.display();
		System.out.println();
		System.out.println(dll.size());
	}

}
