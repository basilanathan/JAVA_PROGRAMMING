package fb.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author basila
 * 
 * // Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

// If two nodes are in the same row and column, the order should be from left to right.

// Examples:

// Given binary tree [3,9,20,null,null,15,7],
//    3
//   /\
//  /  \
//  9  20
//     /\
//    /  \
//   15   7
// return its vertical order traversal as:
// [
//   [9],
//   [3,15],
//   [20],
//   [7]
// ]
// Given binary tree [3,9,8,4,0,1,7],
//      3
//     /\
//    /  \
//    9   8
//   /\  /\
//  /  \/  \
//  4  01   7
// return its vertical order traversal as:
// [
//   [4],
//   [9],
//   [3,0,1],
//   [8],
//   [7]
// ]
// Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
//      3
//     /\
//    /  \
//    9   8
//   /\  /\
//  /  \/  \
//  4  01   7
//     /\
//    /  \
//    5   2
// return its vertical order traversal as:
// [
//   [4],
//   [9,5],
//   [3,0,1],
//   [8,2],
//   [7]
// ]
 * 
 * Time : O(N)
 * Space : O(N)
 *
 */

//BFS, put node, col into queue at the same time
//Every left child access col - 1 while right child col + 1
//This maps node into different col buckets
//Get col boundary min and max on the fly
//Retrieve result from cols

public class BinaryTreeVerticalOrderTraversal {
	
	
	//WITH MIN AND MAX (Better way)
	public static List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		
		if(root == null) return result;
		
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();
		
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		
		queue.add(root);
		cols.add(0);
		
		int min = 0;
		int max = 0;
		
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int col = cols.poll();
			
			if(!map.containsKey(col)) {
				map.put(col, new ArrayList<Integer>());
			}
			map.get(col).add(node.val);
			
			if(node.left != null) {
				queue.add(node.left);
				cols.add(col - 1);
				min = Math.min(min, col - 1);
			}
			if(node.right != null) {
				queue.add(node.right);
				cols.add(col + 1);
				max = Math.max(max, col + 1);
			}
		}
		
		for(int i = min; i <= max; i++) {
			result.add(map.get(i));
		}
		
		return result;
	}
	
	//WITHOUT MIN AND MAX
	public static List<List<Integer>> verticalOrder2(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<TreeNode> nqueue = new LinkedList<>();
		Queue<Integer> lqueue = new LinkedList<>();
		
		nqueue.offer(root);
		lqueue.offer(0);
		
		while(!nqueue.isEmpty()) {
			TreeNode node = nqueue.poll();
			int level = lqueue.poll();
			
			if (!map.containsKey(level)) {
				List<Integer> list = new LinkedList<>();
				map.put(level, list);
				if(level < 0) result.add(0, list);
				else result.add(list);
			}
			map.get(level).add(node.val);
			if(node.left != null) {
				nqueue.offer(node.left);
				lqueue.offer(level - 1);
			}
			if (node.right != null) {
				nqueue.offer(node.right);
				lqueue.offer(level + 1);
			}
		}
		return result;
	}

}
