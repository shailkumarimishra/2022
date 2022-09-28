package datastructure.arrays;

public class MyArrayTest {

	public static void main(String[] args) {
		MyArray array = new MyArray();
		array.add(10);
		array.add(20);
		array.add(30);
		array.add(40);
		array.add(50);
		array.add(60);
		array.addFirst(70);
		array.addLast(80);
		array.add(3, 90);
		array.display();
		System.out.println();
		array.remove(40);
		array.display();
		System.out.println();
		array.removeFirst();
		array.removeLast();
		array.display();
		System.out.println();
		array.removeATIndex(3);
		array.display();
		System.out.println();
		System.out.println(array.contains(900));
	}

}
