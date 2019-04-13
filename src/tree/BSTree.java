package tree;

public class BSTree<T extends Comparable<T>>{
	private TreeNode<T> root;
	
	public TreeNode<T> get_root(){
		return this.root;
	}
	
	public TreeNode<T> search(T val) {
		TreeNode<T> current = this.root;
		while (val != current.data && current != null) {
			if (val.compareTo(current.data) < 0)
				current = current.left;
			else
				current = current.right;
		}
		return current;
	}
	
	public TreeNode<T> minimum(TreeNode<T> current){
		if (current == null)
			current = this.root;
		while (current.left != null) 
			current = current.left;
		return current;
	}
	
	public TreeNode<T> maximum(TreeNode<T> current){
		if (current == null)
			current = this.root;
		while (current.right != null)
			current = current.right;
		return current;
	}
	
	public TreeNode<T> successor(T val) {
		TreeNode<T> current = search(val);
		if (current.right != null)
			return minimum(current.right);
		while (current.parent.left != current && current.parent != null) 
			current = current.parent;
		return current;
	}
	
	public void insert(T val) {
		if (this.root == null) 
			this.root = new TreeNode<T>(val);
		else {
			TreeNode<T> current = this.root;

			while (true) {
				if (val.compareTo(current.data) < 0) 
					if (current.left == null) {
						current.left = new TreeNode<T>(val);
						current.left.parent = current;
						break;
					}
					else 
						current = current.left;
				
				else if(val.compareTo(current.data) > 0) 
					if (current.right == null) {
						current.right = new TreeNode<T>(val);
						current.right.parent = current;
						break;
					}
					else 
						current = current.right;
			}
		}
	}
	
	private void transplant(TreeNode<T> z, TreeNode<T> y) {
		if (z.parent == null) 
			this.root = y;
		else if (z.parent.left == z) 
			z.parent.left = y;
		else if (z.parent.right == z)
			z.parent.right = y;
		if (y != null)
			y.parent = z.parent;
	}
	
	public void delete(T val) {
		TreeNode<T> current = search(val);
		if (current.left == null)
			transplant(current, current.right);
		else if (current.right == null)
			transplant(current, current.left);
		else {
			TreeNode<T> y = minimum(current.right); 
			if (y.parent != current) {
				transplant(y, y.right);
				y.right = current.right;
				y.right.parent = y;
			}
			transplant(current, y);
			y.left = current.left;
			y.left.parent = y;
		}
	}
	
	private int _height(TreeNode<T> node) {
		if (node == null)
			return -1;
		return 1 + Math.max(_height(node.left), _height(node.right));
	}
	
	public int height() {
		return _height(this.root);
	}
	public void inorder_traversal(TreeNode<T> current) {

		if (current == null)
			current = this.root;
		if (current != null){
			if (current.left != null)
				inorder_traversal(current.left);
			System.out.println(current.data);
			if (current.right != null)
				inorder_traversal(current.right);
		}	
	}
	
	public void preorder_traversal(TreeNode<T> current) {
		if (current == null)
			current = this.root;
		if (current != null) {
			System.out.println(current.data);
			if (current.left != null)
				preorder_traversal(current.left);
			if (current.right != null)
				preorder_traversal(current.right);
		}
	}
	
	public void postorder_traversal(TreeNode<T> current) {
		if (current == null)
			current = this.root;
		if (current != null) {
			if (current.left != null)
				postorder_traversal(current.left);
			if (current.right != null)
				postorder_traversal(current.right);
			System.out.println(current.data);
		}
	}
	
	public static void main(String[] args) {
		BSTree<Integer> ob = new BSTree<Integer>();
		ob.insert(15);
		ob.insert(6);
		ob.insert(3);
		ob.insert(7);
		ob.insert(2);
		ob.insert(4);
		ob.insert(13);
		ob.insert(9);
		ob.insert(18);
		ob.insert(17);
		ob.insert(20);
		
		System.out.println("Inorder traversal:- ");
		ob.inorder_traversal(null);
		System.out.println(ob.successor(15).data); //17
	}

}
