package Day10;

import java.util.Stack;

public class Test03_stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> s1 = new Stack<String>();
		s1.push("First");
		System.out.println(s1.peek());
		System.out.println(s1.pop());
		System.out.println(s1.isEmpty());
		
		Stack<Integer> s2 = new Stack<Integer>();
		s2.push(99);
		System.out.println(s2.peek());
		System.out.println(s2.pop());
		System.out.println(s2.isEmpty());
	}

}
