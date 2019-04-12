package tree;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree<T extends Comparable<T>> {
	
	private TreeNode<T> root;
	
	private int _insert(TreeNode<T> temp, T val) {
		if (temp == null) {
			this.root = new TreeNode<T>(val);
			return 1;
		}
		Queue<TreeNode<T>> q = new LinkedList<TreeNode<T>>();
		q.add(temp);
		while (!q.isEmpty()) {
			TreeNode<T> node = q.poll();
			if (node.left == null) {
				node.left = new TreeNode<T>(val);
				return 1;
			} else
				q.add(node.left);
			if (node.right == null) {
				node.right = new TreeNode<T>(val);
				return 1;
			} else
				q.add(node.right);
		}
		return 0;
	}
	
	public void insert(T val) {
		_insert(this.root, val);
	}
	
	public void inorder(TreeNode<T> node) {
		if (node == null)
			node = this.root;
		if (node != null) {
			if (node.left != null)
				inorder(node.left);
			System.out.println(node.data);
			if (node.right != null)
				inorder(node.right);
		}
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> ob = new BinaryTree<Integer>();
		ob.insert(1);
		ob.insert(2);
		ob.insert(3);
		ob.insert(4);
		ob.insert(5);
		ob.insert(6);
		ob.insert(7);
		ob.inorder(null);

	}

}
