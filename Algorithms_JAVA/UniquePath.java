package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	
	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	
	How many possible unique paths are there?
 *
 */

/*
Thoughts:
'how many ways' -> Could do DFS, but try DP
Robot moves: (0, 1) or (1, 0)
gird[x][y]: #paths to reach x,y.
There are only 2 ways for getting to (x, y): from (x-1, y) or (x, y-1)
Then, the sub problem is grid[x-1,y], and grid[x, y-1].
grid[x][y] = Math.min(grid[x-1,y], grid[x, y-1]) + 1;
Boundary: when x = 0, grid[0, 0~y] = 0~y; same for y=0, grid[0~x, 0] = 0~x;
Path: should go from y++ and y=0, because when we advance +1 row, we'd use previous x/y, which should be calculated already.
*/

//Time O(N * M)
//Space O(N * M)

public class UniquePath {
	
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        // Initialization edges to 1
        final int[][] grid = new int[m][n];
        for (int i = 0; i < n; i++) {
            grid[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            grid[i][0] = 1;
        }
        // Calculate based on equation
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[m-1][n-1];        
    }

}

/*
2. 9Chapter solution
Thinking process:
1. Assume (r,c) where r>=1, c>=1. Any node (r,c) has 2 ways to get to: (r-1, c) from top, or (r,c-1) from left-side.
2. (r-1, c) and (r,c-1) stores the possible paths to get to them
3. (r,c) = (r-1, c) + (r,c-1)
4. Initialize the top-row and left-column to be 1: Assuming landing on any initial node has path # of 1.
5. From top-bottom traverse
*/

public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    //Traverse
    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }
        int[][] matrix = new int[m][n];
        //Initialize
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            matrix[0][i] = 1;
        }
        //Traverse
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }
}
