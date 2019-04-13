package tree;
import java.util.Arrays;

public class PostFromInAndPre {

	private static int search1(int[] in, int val) {
		for(int i=0; i<in.length; i++)
			if (in[i] == val)
				return i;
		return 0;
	}
	
	public static void getPostorder1(int[] in, int[] pre) {
		int root_index = search1(in, pre[0]);
		
		if (root_index!=0)
			getPostorder1(Arrays.copyOfRange(in, 0, root_index), Arrays.copyOfRange(pre, 1, root_index+1));
		if (root_index != in.length - 1)
			getPostorder1(Arrays.copyOfRange(in, root_index+1, in.length), Arrays.copyOfRange(pre, root_index+1, pre.length));
		
		System.out.printf("%d ", in[root_index]);
	}
	
	public static void main(String[] args) {
		
		int[] in = {4, 2, 5, 1, 3, 6};
		int[] pre = {1, 2, 4, 5, 3, 6};
		getPostorder1(in, pre);
		// 4 5 2 6 3 1
	}

}
