package cci.ch4;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author basila
 * 
 * 1. The prefix stores the sum from the root to the current node in the recursion
 * 
 * 2. The map stores <prefix sum, frequency> pairs before getting to the current node. 
 * We can imagine a path from the root to the current node. The sum from any node in the middle 
 * of the path to the current node = the difference between the sum from the root to the current 
 * node and the prefix sum of the node in the middle.
 * 
 * 3. We are looking for some consecutive nodes that sum up to the given target value, 
 * which means the difference discussed in 2. should equal to the target value. In addition, 
 * we need to know how many differences are equal to the target value.
 * 
 * 4. Here comes the map. The map stores the frequency of all possible sum in the path to 
 * the current node. If the difference between the current sum and the target value exists in the map,
 * there must exist a node in the middle of the path, such that from this node to the current node,
 * the sum is equal to the target value.
 * 
 * 5. Note that there might be multiple nodes in the middle that satisfy what is discussed in 4.
 * The frequency in the map is used to help with this.
 * 
 * 6. Therefore, in each recursion, the map stores all information we need to calculate 
 * the number of ranges that sum up to target. Note that each range starts from a middle node, 
 * ended by the current node.
 * 
 * 7. To get the total number of path count, we add up the number of valid paths ended by EACH 
 * node in the tree.
 * 
 * 8. Each recursion returns the total count of valid paths in the subtree rooted at the 
 * current node. And this sum can be divided into three parts:
 * - the total number of valid paths in the subtree rooted at the current node's left child
 * - the total number of valid paths in the subtree rooted at the current node's right child
 * - the number of valid paths ended by the current node
 * 
 * - there are two ways to see if the target sum is in a sequence
 * - the first way is checking that the running sum on a node path equals the target sum
 * - the other way is if a subset of the path includes the target sum
 * - for the first way, we just keep track of the number of times the running total equaled the target sum
 * - for the second way, we keep track of the history of running totals for each path
 * - if we subtract the running total from the target sum, we can see what a previous running sum needed to be
 * - we check how many times this previous running sum actually happened and increment the count based on the number of times that running sum occured
 * - we make sure to decrement the running sum from the tracker after the recursive calls because we’re only using one tracker and we want it to track the running sums for only one path each time
 *
 *http://www.yujinc.com/category/cracking-the-coding-interview/page/3/
 */

public class PathSum {
	
	public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return findPathSum(root, 0, sum, map);  
    }
    private int findPathSum(TreeNode curr, int sum, int target, Map<Integer, Integer> map) {
        if (curr == null) {
            return 0;
        }
        // update the prefix sum by adding the current val
        sum += curr.data;
        // get the number of valid path, ended by the current node
        int numPathToCurr = map.getOrDefault(sum-target, 0); 
        // update the map with the current sum, so the map is good to be passed to the next recursion
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        // add the 3 parts discussed in 8. together
        int res = numPathToCurr + findPathSum(curr.left, sum, target, map)
                                               + findPathSum(curr.right, sum, target, map);
       // restore the map, as the recursion goes from the bottom to the top
        map.put(sum, map.get(sum) - 1);
        return res;
    }

}
