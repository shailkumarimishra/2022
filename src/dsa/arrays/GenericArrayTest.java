package dsa.arrays;

public class GenericArrayTest {

	public static void main(String[] args) {
		GenericArrayList<Integer> list=new GenericArrayList<>();
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
		Object[] datas = list.getAll();
		for(Object i:datas)
			System.out.print(i+" ");
	}

}
