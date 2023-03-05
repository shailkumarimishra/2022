package dsa.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixConversion {
	/**
	 * 1. create an empty Stack
	 * 2. do following for every character x from left to right
	 * 		if x is:
	 * 		a)operand: output it or print it
	 * 		b)left parenthesis: push to stack
	 * 		c)right parenthesis: pop from stack until left parenthesis is found, output the popped operators
	 * 		d)operator: if stack is empty push x to stack else compare x with top of the stack
	 * 					case1: higher precedence then push x to stack
	 * 					case2: lower precedence, pop the top of the stack and output until the higher precedence operator is found
	 * 						   then push x to stack.
	 * 					case3: equal precedence use associativity and output everything from the stack
	 * @param str
	 * @return
	 */
public static String infixToPostfix(String str) {
	Map<Character, Integer> precedence = new HashMap<>();
	precedence.put('+', 1);
	precedence.put('-', 1);
	precedence.put('/', 2);
	precedence.put('*', 2);
	precedence.put('^', 3);
	
	String output="";
	// step1: create a new stack
	Stack<Character> stack = new Stack<>();
	//step2: traverse for every character from left to right
	for(int i=0;i<str.length();i++) {
		if(isOperand(str.charAt(i))) {// step2.a) if operand output it
			output=output+str.charAt(i);
		}else if(str.charAt(i)=='(') {// step2.b) if left parenthesis push it
			stack.push(str.charAt(i));
		}else if(str.charAt(i)==')') {// step2.c) if right parenthesis pop until left parenthesis and output it
			while(!stack.isEmpty() && stack.peek()!='(') {
				char ch = stack.pop();
				output=output+ch;
			}
		}else {// step2.d) if operator -
			if(!stack.isEmpty()) {// step2.d.1) if stack is not empty-
				while(!stack.isEmpty()) {
					if(precedence.containsKey(str.charAt(i))) {
						int order = precedence.get(str.charAt(i));
						if(order>precedence.get(stack.peek())) {
							stack.push(str.charAt(i));
						}else if(order<precedence.get(stack.peek())) {
							while(order<precedence.get(stack.peek())) {
								char ch = stack.pop();
								output=output+ch;
							}
							stack.push(str.charAt(i));
						}else if(order==precedence.get(stack.peek())) {
							while(!stack.isEmpty()) {
								char ch = stack.pop();
								output=output+ch;
							}
						}
					}
				}
			}else {// step2.d.2) if stack is  empty push it
				stack.push(str.charAt(i));
			}
		}
	}
	while(!stack.isEmpty()) {
		char ch = stack.pop();
		output=output+ch;
	}
	return output;
}

private static boolean isOperand(char ch) {
	return Character.isLetter(ch);
}

public static void main(String[] args) {
	String str="(b/c)";
	String result = infixToPostfix(str);
	System.out.println(result);
//	System.out.println(isOperand('+'));
}
}
