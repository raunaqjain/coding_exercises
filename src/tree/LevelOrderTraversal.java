package tree;
import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderTraversal {

	private static void level_order_traversal(TreeNode<Integer> root) {

		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while(!q.isEmpty()) {
			
			TreeNode<Integer> node = q.poll();
			if (node == null) {
				if (!q.isEmpty()) {
					q.add(null);
					System.out.println();
				}
			}
			else {
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
				System.out.printf("%d ", node.data);
			}
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
		level_order_traversal(ob.get_root());
	}

}
