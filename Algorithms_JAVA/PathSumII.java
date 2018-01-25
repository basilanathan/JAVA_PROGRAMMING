package fb.glassdoor;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
	
	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	return
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
 * */

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
 * Also using ArrayList allows O(1) access to the each node, that means removing the last element takes only O(1). 
 * If you use LinkedList, initially we have traverse the list to the last node then remove it, which takes O(n) 
 * time.
 * */

//Time: O(N)
//Space: O(N)

//https://discuss.leetcode.com/topic/5414/dfs-with-one-linkedlist-accepted-java-solution

public class PathSumII {
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> current = new ArrayList<>();
		pathSum(root, sum, current, result);
		return result;
	}

	private void pathSum(TreeNode root, int sum, List<Integer> current, List<List<Integer>> result) {
		if(root == null) return;
		
		current.add(root.val);
		if(root.left == null && root.right == null && root.val == sum) {
			result.add(new ArrayList(current));
		} else {
			pathSum(root.left, sum - root.val, current, result);
			pathSum(root.right, sum - root.val, current, result);
		}
		
		current.remove(current.size() - 1);
	}
}

/*  			  5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
 * 
 * pathSum(root 5, 22)
 * current -> [5]
 * 	pathSum(4, 22 - 5 = 17)
 * 	current -> [5, 4]
 * 		pathSum(11, 17 - 4 = 13)
 * 		current -> [5, 4, 11]
 * 			pathSum(7, 13 - 11 = 2)
 * 			current -> [5, 4, 11, 7]
 * 				pathSum(null, 2 - null)
 * 				return
 * 				current -> [5, 4, 11]
 * 			pathSum(2, 2)
 * 			current -> [5, 4, 11, 2]
 * 			result -> {[5, 4, 11, 2]}
 * 			current -> [5, 4, 11]
 * 		current -> [5, 4]
 * 	current -> [5]
 * 	pathSum(8, 22 - 5 = 17)
 * 	current -< [5, 8]
 * */
