package eranbe.recursion;

import eranbe.datastructures.Stack;

public class ReverseStack {
	public static <T> void reverseStack(Stack<T> stack) {
	    if (stack.isEmpty()) {
	        return;
	    }
	    T top = stack.pop();
	    reverseStack(stack);
	    insertAtBottom(stack, top);
	}

	private static <T> void insertAtBottom(Stack<T> stack, T item) {
	    if (stack.isEmpty()) {
	        stack.push(item);
	        return;
	    }
	    T top = stack.pop();
	    insertAtBottom(stack, item);
	    stack.push(top);
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s);
		reverseStack(s);
		System.out.println(s);
	}
}
