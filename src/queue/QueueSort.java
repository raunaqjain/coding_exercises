package queue;

public class QueueSort {
	
	static int sorted_index; // variable maintaining the location of the sorted part in queue
	private static int searchMinValue(Queue<Integer> q, int sorted_count) {
		int size = q.get_size();
		int min_value = q.front.data;
		int min_index = 0;
		
		for(int i=0; i < size; i++) {
			int temp = q.pop();
			// We don't want to search in the sorted part of queue
			if (temp < min_value && i <= sorted_count) {
				min_value = temp;
				min_index = i;
			}
			q.push(temp);
		}
		return min_index;
	}
	
	public static void queueSort(Queue<Integer> q) {
		if (q.isEmpty())
			return;
		sorted_index = q.get_size() - 1;
		while (sorted_index >= 0 ) {
			int min_index = searchMinValue(q, sorted_index);
			int min_value = 0;
			int size = q.get_size();
			
			for (int i=0; i<size; i++) {
				int temp = q.pop();
				if (i != min_index) {
					q.push(temp);
				} else {
					min_value = temp;
				}
			}
			q.push(min_value);
			sorted_index--;
		}
		q.display();
	}
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		int[] a = {4, 3, 5, 1, 2};
		for (int i=0; i < a.length; i++)
			q.push(a[i]);
		System.out.print("Original array: ");
		q.display();
	    System.out.printf("\nSorted array: ");
		queueSort(q);
	}

}
