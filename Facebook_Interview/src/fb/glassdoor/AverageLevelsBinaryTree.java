package fb.glassdoor;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*	BFS SOLUTION
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
	Example 1:
	Input:
	    3
	   / \
	  9  20
	    /  \
	   15   7
	Output: [3, 14.5, 11]
	Explanation:
	The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
	Note:
	The range of node's value is in the range of 32-bit signed integer.
 * */
/*
 * Complexity Analysis
 * Time complexity : O(n). The whole tree is traversed atmost once. Here, n
 * refers to the number of nodes in the given binary tree.
 * Space complexity : O(m). The size of queue or temp can grow upto atmost 
 * the maximum number of nodes at any level in the given binary tree. Here, m
 *  refers to the maximum mumber of nodes at any level in the input tree.
 * */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class AverageLevelsBinaryTree {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int count = queue.size();
			double sum = 0;
			for(int i = 0; i < count; i++) {
				TreeNode current = queue.poll();
				sum += current.val;
				if(current.left != null) queue.offer(current.left);
				if(current.right != null) queue.offer(current.right);
			}
			list.add(sum / count);
		}
		return list;
	}

}
