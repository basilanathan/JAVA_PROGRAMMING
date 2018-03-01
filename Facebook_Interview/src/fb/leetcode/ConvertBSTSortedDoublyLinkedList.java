package fb.leetcode;

/* https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/544/
 * https://articles.leetcode.com/convert-binary-search-tree-bst-to/
 * http://yuanhsh.iteye.com/blog/2194096
 * */

public class ConvertBSTSortedDoublyLinkedList {
	
	public static TreeNode convertBstToDLL(TreeNode root) {
	    // convert bst to circular dll 
	    if (root == null)
	        return (null);

	    // Recursively do the subtrees (leap of faith!)
	    TreeNode lln = convertBstToDLL(root.left);
	    TreeNode rrn = convertBstToDLL(root.right);

	    // Make root a circular DLL
	    root.left = root;
	    root.right = root;

	    // At this point we have three lists, merge them
	    lln = appendDLL(lln, root);
	    lln = appendDLL(lln, rrn);

	    return lln;
	}

	public static TreeNode appendDLL(TreeNode a, TreeNode b) {
	    // append 2 circular DLL
	    if (a == null)
	        return b;
	    if (b == null)
	        return a;

	    TreeNode aLast = a.left;
	    TreeNode bLast = b.left;

	    aLast.right = b;
	    b.left = aLast;
	    bLast.right = a;
	    a.left = bLast;

	    return a;
	}
	
	Solution 2: iteration
	O(n) time, O(h) space

	public TreeNode bstToDoublyList(TreeNode root) {  
	    TreeNode head = null, prev = null;
	    Stack<TreeNode> stack = new Stack<>();
	    while (root != null || !stack.empty()) {
	        while (root != null) {
	            stack.push(root);
	            root = root.left;
	        }
	        root = stack.pop();
	        root.left = prev;
	        if (prev != null)	prev.right = root;
	        else 	head = root;
	        TreeNode right = root.right;
	        head.left = root;
	        root.right = head;//remember to update the prev !!!
	        prev = root;
	        root = right;//we should root=root.right even if it's null!!!
	    }
	    return head;
	}
	
	//solution 2
	private TreeNode prev;  
	private TreeNode head;  
	public TreeNode bstToSortedDLL(TreeNode node) {  
	    if(node == null) return null;  
	    bstToSortedDLL(node.left);  
	    node.left = prev;  
	    if(prev != null) {  
	        prev.right = node;  
	    } else {  
	        head = node;  
	    }  
	    prev = node;  
	    TreeNode right = node.right;  
	    head.left = node;  
	    node.right = head;  
	    bstToSortedDLL(right);  
	    return head;  
	} 

}
