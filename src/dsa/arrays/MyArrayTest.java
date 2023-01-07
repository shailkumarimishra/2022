package dsa.arrays;

public class MyArrayTest {

	public static void main(String[] args) {
		MyArrayList list=new MyArrayList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(70);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.display();
		System.out.println();
		System.out.println(list.size());
		list.add(3, 99);
		System.out.println(list.size());
		list.display();
	}

}
