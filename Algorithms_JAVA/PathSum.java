package fb.leetcode;

import java.util.ArrayList;
import java.util.List;

import fb.glassdoor.TreeNode;

/**
 * 
 * @author basila
 * 
 * The time complexity of this solution is O(n). It is the same time complexity as that of 
 * recursive in-order traversal. An intuitive way to arrive at this answer is asking: 
 * how many times does each node in the tree get operated/visited on? The answer is 1 time per node.

If you really want to be thorough in explaining to interviewer, one could say: it would be O(n) + O(p h) 
where p is the number of root to leaf paths and h is the height of the tree. The reason we include O(p*h) 
is because of the

result.add(new LinkedList(currentResult));

For each possible path, we have to make a deep copy of this list, which takes O(h) 
for one path and there are p such paths. But O(n) + O(ph) would be O(n).
 *
 *	https://leetcode.com/problems/path-sum-ii/discuss/36683
 */

public class PathSum {
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> current = new ArrayList<Integer>();
		
		pathSum(root, sum, current, result);
		return result;
	}

	private void pathSum(TreeNode root, int sum, List<Integer> current, List<List<Integer>> result) {
		if(root == null) return;
		
		current.add(root.val);
		if(root.left == null && root.right == null) {
			result.add(new ArrayList(current));
		} else {
			pathSum(root.left, sum - root.val, current, result);
			pathSum(root.right, sum - root.val, current, result);
		}
		
		current.remove(current.size() - 1);
		
	}

}

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

/*
 * The basic idea is to subtract the value of current node from sum until it reaches a 
 * leaf node and the subtraction equals 0, then we know that we got a hit. Otherwise the 
 * subtraction at the end could not be 0.
 * */

public class PathSum {
	
	public boolean pathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.left == null && root.right == null && sum - root.val == 0) return true;
		return pathSum(root.left, sum - root.val) || pathSum(root.right, sum - root.val);
	}

}
