package fb.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIteratorList {
	
	List<Integer> result;
	int count = 0;
	
	public void BSTIteractor(TreeNode root) {
		result = new ArrayList<Integer>();
		inorder(root);
	}

	private void inorder(TreeNode root) {
		if(root == null) return;
		
		inorder(root.left);
		result.add(root);
		inorder(root.right);
		
	}
	
	public boolean hasNext() {
		if(count < result.size())
			return true;
		return false;
	}
	
	public int next() {
		int val = result.get(count);
		count++;
		return val;
	}

}
