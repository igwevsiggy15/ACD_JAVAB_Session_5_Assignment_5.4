package Assignment4;


interface Stack{
	void push(int i);
	int pop();
}

class StackNode{
	int i;
	StackNode next;
	
	public StackNode(int i, StackNode next) {
		this.i = i;
		this.next = next;
	}
}

class FixedStack implements Stack{
	private int curr;
	private int[] head;
	
	public FixedStack(int i) {
		this.head = new int[i];
		this.curr = -1;
	}
	
	@Override
	public void push(int i) {
		// TODO Auto-generated method stub
		if (this.curr < (head.length-1)) {
			head[curr+1] = i;
			curr++;
		} else {
			System.out.println("Stack overflow.");
		}
	}

	@Override
	public int pop() {
		// TODO Auto-generated method stub
		if (this.hasNext()) {
			curr--;
			return head[curr+1];
		}
		System.out.println("Stack is empty.");
		return -1;
	}
	
	public boolean hasNext() {
		if (curr > -1) {
			return true;
		} return false;
	}
	
}

class VariableStack implements Stack{
	private StackNode head;
	
	@Override
	public void push(int i) {
		// TODO Auto-generated method stub
		StackNode nHead = new StackNode(i, head);
		this.head = nHead;
	}

	@Override
	public int pop() {
		// TODO Auto-generated method stub
		if (head != null) {
			int i = head.i;
			this.head = head.next;
			return i;
		} else {
			System.out.println("Stack is empty.");
			return -1;
		}
	}
	
	public boolean hasNext() {
		if (head != null) {
			return true;
		}
		return false;
	}
	
}

public class StackMain {
	public static void main(String[] args) {
		FixedStack fs = new FixedStack(6);
		VariableStack vs = new VariableStack();
		
		System.out.println("Pushing 6 numbers to both stacks.");
		for (int i = 0; i < 6; i++) {
			fs.push(i);
			vs.push(i);
		}
		
		System.out.println("Pushing another to Fixed Stack");
		fs.push (6);
		
		System.out.println("Printing Fixed Stack: ");
		while (fs.hasNext()) {
			System.out.println(fs.pop());
		}
		
		System.out.println("\nPushing another to Variable Stack.");
		vs.push (6);
		System.out.println("Printing Variable Stack: ");
		while (vs.hasNext()) {
			System.out.println(vs.pop());
		}
		
		
		
		
	}
}