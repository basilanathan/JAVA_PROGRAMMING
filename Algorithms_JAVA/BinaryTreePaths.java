package fb.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author basila
 * 
 * Given a binary tree, return all root-to-leaf paths.

	For example, given the following binary tree:
	
	   1
	 /   \
	2     3
	 \
	  5
	All root-to-leaf paths are:
	
	["1->2->5", "1->3"]
 * 
 * 
 * The time complexity for the problem should be O(n), since we are basically visiting each node in the tree. 
 * Yet an interviewer might ask you for further optimization when he or she saw a string concatenation. 
 * A string concatenation is just too costly. A StringBuilder can be used although a bit tricky since it is 
 * not immutable like string is.
 * 
 * When using StringBuilder, We can just keep track of the length of the StringBuilder before we append 
 * anything to it before recursion and afterwards set the length back. Another trick is when to append the "->", 
 * since we don't need the last arrow at the end of the string, we only append it before recurse to the next 
 * level of the tree. Hope the solution helps!
 * 
 * Using StringBuilder, we could make sure that String allocation and copying only happens when we are at a leaf. 
 * That means, the cost would be now sum of length of all root-to-leaf paths rather than sum of length of all 
 * root-to-node paths. This is assuming that StringBuilder.append and StringBuilder.setLength can work in O(1) 
 * or at least less than O(N) time.
 *
 */

public class BinaryTreePaths {
    //BFS - Queue
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> list=new ArrayList<String>();
        Queue<TreeNode> qNode=new LinkedList<TreeNode>();
        Queue<String> qStr=new LinkedList<String>();

        if (root==null) return list;
        qNode.add(root);
        qStr.add("");
        while(!qNode.isEmpty()) {
            TreeNode curNode=qNode.remove();
            String curStr=qStr.remove();

            if (curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
            if (curNode.left!=null) {
                qNode.add(curNode.left);
                qStr.add(curStr+curNode.val+"->");
            }
            if (curNode.right!=null) {
                qNode.add(curNode.right);
                qStr.add(curStr+curNode.val+"->");
            }
        }
        return list;
    }
	
	//string concatenation operation becomes more expensive when going deeper. 
    //“StringBuilder” is a mutable object, it will hold its value after returning.
    //Whereas String creates a copy in every recursion, you don’t need to worry about the “side-effect” when backtrack.
	//the total time complexity is O(n logn). you are touching every node and and you are traversing the height of the tree
	//each node for O(n), but each call requires a concatenation bounded by the height of the tree, the 
	//complexity should be O(n * h) or in the case of a balanced tree O(n * logn)
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		
		if(root == null) return result;
		
		helper(root, "", result);
		return result;
	}

	private void helper(TreeNode root, String current, List<String> result) {
		if(root.left == null && root.right == null) result.add(current + root.val);
		if(root.left != null) helper(root.left, current + root.val + " -> ", result);
		if(root.right != null) helper(root.right, current + root.val + " -> ", result);
		
	}
	
	//WITH STRING BUILDER
    public List<String> binaryTreePathsSB(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(result, root, sb);
        return result;
    }
    
    private void helper(List<String> result, TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null) {
        	result.add(sb.toString()); //if there are no root.left or root.right, add root to result
        } else {
            sb.append("->");
            helper(result, root.left, sb);
            helper(result, root.right, sb);
        }
        sb.setLength(len); //set it back to the old length (essentialy making a new String Builder) backtrack
    }
    
//    *****Follow Up1****
//    If we cannot use dfs(which is easy for printing paths)
//    then use bfs, use hashmap to store parent-to-children paths

    public void binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)    return res;
        HashMap<TreeNode, TreeNode> map = new HashMap<>(); // (node, parent node)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root, null);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left == null && curr.right == null) {
                String path = getPath(map, curr);//if you only want to print paths, we can use recursion here
                res.add(path);
            }
            if (curr.left != null) {
                map.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                map.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
        return res;
    }
    private String getPath(HashMap<TreeNode, TreeNode> map, TreeNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {//from leaf to root
            sb.append(node.val + ">-");
            node = map.get(node);
        }
        return sb.reverse().substring(2);
    }

}
