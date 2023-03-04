package dsa.stack;

import java.util.Stack;

public class ProblemPractice {
// Q1. Validate the given "()((()))" 
	public boolean validateBracket(String str) {
		Stack<String> stack = new Stack<String>();
		String[] brackets = str.split("");
		int index=0;
		while(index<brackets.length) {
			if(brackets[index].equalsIgnoreCase("("))
				stack.push(brackets[index]);
			else
				stack.pop();
			index++;
		}
		
		return stack.isEmpty();
	}
	
	
}
