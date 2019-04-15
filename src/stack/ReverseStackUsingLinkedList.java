package stack;

public class ReverseStackUsingLinkedList {

	public static void reverse(Stack<Integer> s) {
		Node<Integer> prev, curr, succ;
		curr = prev = s.head;
		curr = curr.next;
		prev.next = null;
		
		while(curr!=null) {
			succ = curr.next;
			curr.next = prev;
			prev = curr;
			curr = succ;
		}
		s.head = prev;
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		int[] a = {5,4,3,2,1};
		for (int i=0; i < a.length; i++)
			s.push(a[i]);
		s.display();
		System.out.println();
		reverse(s);
		System.out.println("Output: ");
		s.display();
	}

}
