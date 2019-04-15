package stack;

public class Stack<T> {
	Node<T> head;
	int size;
	
	public Stack() {
		this.head = null;
		this.size = 0;
	}
	
	public int get_size() {
		return this.size;
	}
	public boolean is_empty() {
		return this.head == null;
	}
	
	public void push(T data) {
		Node<T> temp = new Node<T>(data);
		this.size++;
		if (this.is_empty()) {
			this.head = temp;
		} 
		else {
			temp.next = this.head;
			this.head = temp;
		}
	}
	
	public T pop() {
		if (this.is_empty()) {
			System.out.println("OVERFLOW!!");
			return null;
		}
		else {
			Node<T> temp = this.head;
			this.head = this.head.next;
			this.size--;
			return temp.data;
		}
	}
	
	public void display() {
		Node<T> temp = this.head;
		for(int i=0; i < this.get_size(); i++) {
			System.out.printf("%d ", temp.data);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		int[] a = {5,4,3,2,1};
		for (int i=0; i < a.length; i++) 
			s.push(a[i]);
		s.display();
	}

}
