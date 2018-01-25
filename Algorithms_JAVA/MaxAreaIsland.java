package fb.glassdoor;

/*
	Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
	Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
	
	Example 1:
	
	[[0,0,1,0,0,0,0,1,0,0,0,0,0],
	 [0,0,0,0,0,0,0,1,1,1,0,0,0],
	 [0,1,1,0,1,0,0,0,0,0,0,0,0],
	 [0,1,0,0,1,1,0,0,1,0,1,0,0],
	 [0,1,0,0,1,1,0,0,1,1,1,0,0],
	 [0,0,0,0,0,0,0,0,0,0,1,0,0],
	 [0,0,0,0,0,0,0,1,1,1,0,0,0],
	 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
	
	Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
	
	Example 2:
	
	[[0,0,0,0,0,0,0,0]]
	
	Given the above grid, return 0.
	
	Note: The length of each dimension in the given grid does not exceed 50.
*/

/*
 * Worst-case recursion depth will be O(mn), where m is the width of the grid and n is the height
 * 
 * So space complexity will be O(mn)
 * */

public class MaxAreaIsland {
	
    int max = 0, maxNow = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    maxNow = 0;
                    dfs(i, j, grid);}
            }
        }
        return max;
    }
    
    private void dfs(int i, int j, int[][]grid) {
        if (i < 0 || j < 0 || 
            i >= grid.length || j >= grid[0].length ||
            grid[i][j] != 1) return;
        grid[i][j] = -1; // marking part of island visited not to check it next time
        maxNow++;
        
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);

        max = Math.max(max, maxNow);
    }

}
