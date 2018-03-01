package fb.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	
	/*
    recap 3.15.2016
    Iterative
    stack: add left till end; consume top, if has right, add right; push right.left till end of right's left node.
*/
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        //Initialize
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        //iteratively add && process via inorder traversal
        while (!stack.isEmpty()) {
            node = stack.pop();
            rst.add(node.val);
            if (node.right != null) {//process right, but put right's left children on top of stack
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            
        }
        return rst;
    }
    
    public class Solution {
        /**
         * @param root: The root of binary tree.
         * @return: Inorder in ArrayList which contains node values.
         */
        public ArrayList<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> rst = new ArrayList<Integer>();
            if (root == null) {
                return rst;
            }
            helper(rst, root);
            
            return rst;
        }

        public void helper(ArrayList<Integer> rst, TreeNode node) {
            if (node == null) {
                return;
            }
            helper(rst, node.left);
            rst.add(node.val);
            helper(rst, node.right);
        }
    }
}

}
