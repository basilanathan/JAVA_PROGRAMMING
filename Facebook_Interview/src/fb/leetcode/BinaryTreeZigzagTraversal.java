package fb.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagTraversal {
	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        List<List<Integer>> res = new ArrayList<>();
        //if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        boolean zigzag = false; //false = left to right and true = right to left
        
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int cnt = queue.size();
            
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                if (zigzag) {
                    level.add(0, node.val);
                }
                else {
                    level.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
            zigzag = !zigzag;
        }
        return res;
        
    }

}
