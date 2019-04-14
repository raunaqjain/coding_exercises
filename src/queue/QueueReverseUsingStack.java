package queue;

public class QueueReverseUsingStack {
	static Queue<Integer> queue;
	
	private static Queue<Integer> reverse(Queue<Integer> q) {
		if (q.isEmpty())
			return q;
		else {
			int data = q.pop();
			reverse(q);
			q.push(data);
			return q;
		}
	}
	
	public static void main(String[] args) {
		
		queue = new Queue<Integer>();
		int[] a = {5, 4, 3, 2, 1};
		for (int i=0; i < a.length; i++)
			queue.push(a[i]);
		queue.display();
		System.out.println("\nReversed Output - ");
		Queue<Integer> temp = reverse(queue);
		temp.display();

	}

}
