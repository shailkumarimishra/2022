package datastructure.arrays;

public class MyArrayTest {

	public static void main(String[] args) {
//		MyArray array = new MyArray();
		MyDynamicArray array = new MyDynamicArray();
		System.out.println("Test Case 1:- \n o/p:- Array is Empty...\n -1");
		array.remove(10);
		array.display();
		System.out.println();
		
		System.out.println("Test Case 2:- \n o/p:- [10,20,30,40,50,60]");
		array.add(10);
		array.add(20);
		array.add(30);
		array.add(40);
		array.add(50);
		array.add(60);
		array.display();
		System.out.println();
		
		System.out.println("Test Case 3:- \n o/p:- [70,10,20,90,30,40,50,60,80]");
		array.addFirst(70);
		array.addLast(80);
		array.add(3, 90);
		array.display();
		System.out.println();
		
		System.out.println("Test Case 4:- \n o/p:- [70,10,20,90,30,50,60,80]");
		array.remove(40);
		array.display();
		System.out.println();
		
		System.out.println("Test Case 5:- \n o/p:- [10,20,90,30,50,60]");
		array.removeFirst();
		array.removeLast();
		array.display();
		System.out.println();
		
		System.out.println("Test Case 6:- \n o/p:- [10,20,90,50,60]");
		array.removeATIndex(3);
		array.display();
		System.out.println();
		
		System.out.println("Test Case 7:- \n o/p:- flase");
		System.out.println(array.contains(900));
		System.out.println();
		
		System.out.println("Test Case 8:- \n o/p:- [10,20,90,50,60,70,80,90,100,110]\n 10");
		array.add(70);
		array.add(80);
		array.add(90);
		array.add(100);
		array.add(110);
		array.display();
		System.out.println(array.size());
		System.out.println();
		
		System.out.println("Test Case 9:- \n o/p:- [10,20,90,50,60,70,120,80,90,100,110]");
		array.add(6, 120);
		array.display();
		System.out.println();
		
		System.out.println("Test Case 10:- \n o/p:- [130,10,20,90,50,60,70,120,80,90,100,110]");
		array.addFirst(130);
		array.display();
		System.out.println();
		
		System.out.println("Test Case 11:- \n o/p:- [10,20,90,50,60,70,120,80,90,100,110]");
		array.addLast(140);
		array.display();
		System.out.println();
		
	}

}
