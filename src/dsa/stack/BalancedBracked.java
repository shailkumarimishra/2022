package dsa.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBracked {
	
public boolean isBalanced(String str) {
	Map<Character, Character> brackets = new HashMap<>(3);
	brackets.put('}','{');
	brackets.put(']','[');
	brackets.put(')','(');
	
	Stack<Character> stack = new Stack<>();
	
	for(int i=0;i<str.length();i++) {
		char ch = str.charAt(i);
		if(brackets.containsValue(ch)) {
			stack.push(ch);
		}else{
			if(stack.isEmpty()) {
				return false;
			}else if(brackets.get(ch)!=stack.peek()) {
				return false;
			}else {
				stack.pop();
			}
		}
	}
	
	return stack.isEmpty() ? true : false;
}
}
