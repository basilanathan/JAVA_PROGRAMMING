package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * https://www.geeksforgeeks.org/sum-nodes-binary-tree/
 *
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int x) {
		val = x;
		//left = right = null;
	}
}

public class SumOfTree {
	
	TreeNode root;
	
	public TreeNode sortedArrayToBst(int[] array, int start, int end) {
		
		if(start > end) return null;
		
		int midd = (start + end) / 2;
		TreeNode node = new TreeNode(array[midd]);
		
		node.left = sortedArrayToBst(array, start, midd - 1);
		
		node.right = sortedArrayToBst(array, midd + 1, end);
		
		return node;
	}

	public int sumBST(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return root.val;
		
		return root.val + sumBST(root.left) + sumBST(root.right);
	}
	
	public static void main(String[] args) {
		SumOfTree test = new SumOfTree();
		int[] array = {1, 2, 3, 4, 5};
		int n = array.length;
		TreeNode root = test.sortedArrayToBst(array, 0, n - 1);
		//System.out.println(root.right.right.val);
		//System.out.println(root.left.val);
		
		System.out.println(test.sumBST(root));
	}
	
}
