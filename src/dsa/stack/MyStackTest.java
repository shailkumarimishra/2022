package dsa.stack;

public class MyStackTest {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.display();
		System.out.println();
		stack.pop();
		stack.display();
		System.out.println();
		System.out.println(stack.peek());
		stack.display();
		System.out.println();
		
	}

}
