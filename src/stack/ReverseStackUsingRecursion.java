package stack;

public class ReverseStackUsingRecursion<T> {

	public static void insert_at_bottom(Stack<Integer> s, int temp) {
		if(s.is_empty())
			s.push(temp);
		else {
			int a = s.pop();
			insert_at_bottom(s, temp);
			s.push(a);
		}
	}
	
	public static void reverse(Stack<Integer> s) {
		if (!s.is_empty()) {
			int temp = s.pop();
			reverse(s);
			insert_at_bottom(s, temp);
		}
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
