package queue;

class Node<T>{
	T data;
	Node<T> next;
	
	public Node(T data){
		this.data = data;
		this.next = null;
	}
}

public class Queue<T> {
	int size;
	Node<T> front, rear;
	
	public Queue() {
		this.size = 0;
		this.front = null;
		this.rear = null;
	}

	public int get_size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.front == null;
	}
	
	public void push(T data) {
		Node<T> temp = new Node<T>(data);
		this.size++;
		if (this.rear == null) {
			this.rear = this.front = temp;
			return;
		}
		else {
			this.rear.next = temp;
			this.rear = temp;
		}
	}
	
	public T pop() {
		if (this.front == null) {
			System.out.println("UNDERFLOW!!");
			return null;
		}
		
		Node<T> temp = this.front;
		this.front = this.front.next;
		this.size--;
		
		if (this.front == null)
			this.rear = null;
		return temp.data;
	}
	
	public void display() {
		Node<T> node = this.front;
		for (int i=0; i < this.get_size(); i++) {
			System.out.printf("%d ", node.data);
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		int[] a = {5, 4, 3, 2, 1};
		for (int i=0; i < a.length; i++)
			q.push(a[i]);
		q.display();
		System.out.println();
		q.push(10);
		q.display();
	}

}
