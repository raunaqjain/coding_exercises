package tree;

public class TreeNode<T> {
	T data;
	TreeNode<T> left, right, parent;
	
	public TreeNode(T val) {
		this.data = val;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

}
