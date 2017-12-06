package cci.ch4;

import helpers.TreeNode;

/**
 * 
 * @author basila
 * @date 12/6/17
 * 
 * <br> Problem Statement :
 * 
 * T1 and T2 are two very large binary trees, with T1
 * much bigger then T2. Create an algorithm to determine
 * if T2 is a subtree of T1. 
 * A tree T2 is a subtree of T1 if there exists a node n
 * in T1 such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two
 * trees would be identical.
 * 
 * </br>
 * 
 * Time: O(n + km) we call areTreesSame k times, where k is the number of occurences
 * of t2's root in t1. 
 *
 */

public class CheckSubtree {
	//Method to check if t1 contains t2

	public static boolean containsTree(TreeNode t1, TreeNode t2) {
		//empty tree is always a subtree
		if(t2 == null) return true;
		//check if t1 contains t2
		return isSubTree(t1, t2); 
	}
	
	//Method to check if Tree T2 is subtree of Tree T1 when head node of both trees are given
	private static boolean isSubTree(TreeNode root1, TreeNode root2) {
		//if parent tree is null return false
		if (root1 == null) {
			return false;
		} else if(root1.data == root2.data && areTreesSame(root1, root2)) {
			//if data match and trees are same, return true
			return true;
		}
		//keep moving down and check if left subtree or right subtree contains the given t2
		return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
	}
	
	//Method to check if two trees are same given the root nodes
	private static boolean areTreesSame(TreeNode root1, TreeNode root2) {
		//if both are null, they are subtree
		if(root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			//if one is null, they are not
			return false;
		} else if(root1.data != root2.data) {
			//if root doesnt match, they are not the same
			return false;
		} else {
			//keep checking for similarity level by level
			return areTreesSame(root1.left, root2.left) && areTreesSame(root1.right, root2.right);
		}
	}
	
	public static void main(String[] args) {
		// t2 is a subtree of t1
		int[] array1 = {1, 2, 1, 3, 1, 1, 5};
		int[] array2 = {2, 3, 1};
		
		TreeNode t1 = TreeNode.createTreeFromArray(array1);
		TreeNode t2 = TreeNode.createTreeFromArray(array2);

		if (containsTree(t1, t2)) {
			System.out.println("t2 is a subtree of t1");
		} else {
			System.out.println("t2 is not a subtree of t1");
		}

		// t4 is not a subtree of t3
		int[] array3 = {1, 2, 3};
		TreeNode t3 = TreeNode.createTreeFromArray(array1);
		TreeNode t4 = TreeNode.createTreeFromArray(array3);

		if (containsTree(t3, t4)) {
			System.out.println("t4 is a subtree of t3");
		} else {
			System.out.println("t4 is not a subtree of t3");
		}
	}

}
