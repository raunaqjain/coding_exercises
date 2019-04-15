package queue;

public class CircularQueue<T> {
	int size;
	Node<T> front, rear;
	
	public CircularQueue() {
		this.front = this.rear = null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return (this.front == null);
	}
	
	public int get_size() {
		return this.size;
	}
	
	public void push(T data) {
		Node<T> temp = new Node<T>(data);
		this.size++;
		
		if (this.isEmpty()) 
			this.front = temp;
		else
			this.rear.next = temp;
		
		this.rear = temp;
		this.rear.next = this.front;
	}
	
	public T pop() {
		if (this.isEmpty()) {
			System.out.println("UNDERFLOW!!");
			return null;
		}
		
		T temp = this.front.data;
		this.size--;
		if (this.front == this.rear) {
			this.front = this.rear = null;
		} else {
			this.front = this.front.next;
			this.rear.next = this.front;
		}
		return temp;
	}
	
	public void display() {
		Node<T> node = this.front;
		for (int i=0; i < this.get_size(); i++) {
			System.out.printf("%d ", node.data);
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		CircularQueue<Integer> q = new CircularQueue<Integer>();
		int[] a = {5, 4, 3, 2, 1};
		for (int i=0; i < a.length; i++)
			q.push(a[i]);
		q.display();
		System.out.println();
		q.pop();
		q.push(10);
		q.display();
	}

}
