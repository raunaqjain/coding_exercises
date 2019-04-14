package stack;

class Node<T>{
	T data;
	Node<T> next;
	
	public Node(T data) {
		this.data = data;
		this.next = null;
	}
}

public class Stack<T> {
	private Node<T> head;
	private int size;
	
	public Stack() {
		this.head = null;
		this.size = 0;
	}
	
	public int get_size() {
		return this.size;
	}
	public boolean is_empty() {
		return this.size == 0;
	}
	
	public void push(T data) {
		if (this.is_empty()) {
			this.head = new Node<T>(data);
		} 
		else {
			Node<T> temp = new Node<T>(data);
			temp.next = this.head;
			temp = this.head;
			this.size++;
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

}
