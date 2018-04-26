package fb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author basila
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).

	For example:
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its level order traversal as:
	[
	  [3],
	  [9,20],
	  [15,7]
	]
 *
 * Time : O(N)
 * Space : O(N)
 */

public class BinaryTreeLevelOrderTraversal {
	
	public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		if(root == null) return wrapList;
		
		queue.offer(root);
		while(!queue.isEmpty()) {
			int level = queue.size();
			List<Integer> subList = new LinkedList<Integer>();
			for(int i = 0; i < level; i++) {
				if(queue.peek().left != null) queue.offer(queue.peek().left);
				if(queue.peek().right != null) queue.offer(queue.peek().right);
				subList.add(queue.poll());
			}
			wrapList.add(subList);
		}
		return wrapList;
	}
	
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();  
		if (root == null) return res;  
			Queue<TreeNode> queue = new LinkedList<>();  
			queue.add(root);  
			while (!queue.isEmpty()) {  
				List<Integer> level = new ArrayList<>();  
				int cnt = queue.size();  
				for (int i = 0; i < cnt; i++) {  
					TreeNode node = queue.poll();  
					level.add(node.val);  
					if (node.left != null) {  
						queue.add(node.left);  
					}
					if (node.right != null) {  
						queue.add(node.right);  
					}
				}  
				res.add(level);   
			}  
		return res;
	}
	
	public List<List<Integer>> levelOrderRepeat(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int count = queue.size();
			for(int i = 0; i < count; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
			}
			result.add(level);
		}
		return result;
	}

}
