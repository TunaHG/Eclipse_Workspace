package Prob.Prob09;

public class MyStack{
	private int[] stack;
	int index = 0;
	
	public MyStack(){
		stack = new int[10];
	}
	public MyStack(int size) {
		if(size > 0) stack = new int[size];
		else stack = new int[10];
	}
	
	public void push(int num) {
		if(isFull()) {
			int[] tmp = new int[stack.length * 2];
			System.arraycopy(stack, 0, tmp, 0, stack.length);
			stack = tmp;
		}
		stack[index++] = num;
	}
	public boolean isEmpty() {
		if(index > 0) return false;
		else return true;
	}
	public boolean isFull() {
		if(index == stack.length) return true;
		else return false;
	}
	public int top() {
		if(isEmpty()) return -1;
		else return stack[index - 1];
	}
	public int pop() {
		if(index > 0) return stack[--index];
		else return -1;
	}
}

