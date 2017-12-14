package cci.ch10;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * Imagine you are reading in a stream of integers. Periodically,
 * you wish to be able to look up the rank of a number x (the number
 * of values less then or equal to x). Implement the data structure 
 * and algorithms to support these operations. That is, implement
 * the method track(int x), which is called when each number is 
 * generated, and the method getRankOfNumber(int x), which returns the
 * number of values less then or equal to x (not including x itself).
 * 
 * Example : 
 * Stream (in order of appearance) : 5, 1, 4, 4, 5, 9, 7, 13, 3
 * getRankOfNumber(1) = 0
 * getRankOfNumber(3) = 1
 * getRankOfNumber(4) = 3
 * 
 * </br>
 * 
 * Time: O(log N) in a balanced tree O(N) in an unbalanced tree.
 *
 */


public class RankFromStream {
	
    private static NodeWithRank root = null;

    private static class NodeWithRank {
        int value;
        int leftSize = 0;
        NodeWithRank left = null;
        NodeWithRank right = null;
        public NodeWithRank(int v) {
            value = v;
        }
    }
    
    public static void track(int x) {
        if (root == null) root = new NodeWithRank(x);
        else track(x, root);
    }

    private static void track(int x, NodeWithRank n) {
        NodeWithRank newNode = new NodeWithRank(x);
        if (x <= n.value) {
            ++n.leftSize; //include the root node (++n.leftSize)
            if (n.left == null) {
                n.left = newNode;
            } else {
                track(x, n.left);
            }
        } else {
            if (n.right == null) {
                n.right = newNode;
            } else {
                track(x, n.right);
            }
        }
    }

    public static int getRankOfNumber(int x) {
        if (root == null) return -1;
        return getRankOfNumber(x, root);
    }

    private static int getRankOfNumber(int x, NodeWithRank n) {
        if (n == null) {
            return -1;
        } else if (x == n.value) {
            return n.leftSize;
        } else if (x <= n.value) {
            int leftRank = getRankOfNumber(x, n.left);
            return leftRank == -1 ? -1 : leftRank;
        } else {
            int rightRank = getRankOfNumber(x, n.right);
            return rightRank == -1 ? -1 : n.leftSize + 1 + rightRank;
        }
    }


	
	public static void main(String[] args) {
		System.out.println(getRankOfNumber(1));
		
		track(5);
		track(1);
		track(4);
		track(4);
		track(4);
		track(5);
		track(9);
		track(7);
		track(13);
		track(3);
		
		System.out.println(getRankOfNumber(1));
		System.out.println(getRankOfNumber(13));
	}
}
