package fb.glassdoor;

/**
 * 
 * @author basila
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
	
	Example 1:
	
	11110
	11010
	11000
	00000
	Answer: 1
	
	Example 2:
	
	11000
	11000
	00100
	00011
	Answer: 3
 *
 *https://discuss.leetcode.com/category/208/number-of-islands
 */

/*The time complexity is O(m*n), where m and n are the width and height of the grid, respectively. The time complexity is only "linear" in the number of cells in the grid.

Since we are conducting a depth-first search on grid, we have to touch every cell in grid at least once.

However, in the worst-conceivable case, we're only touching every interior cell in grid five times (and touching the exterior cells three or four times).
 * 
 * */

public class NumberOfIslands {
	

    private int n;
    private int m;
    
    /**
     * Given a 2d grid map of '1's (land) and '0's (water),
     * count the number of islands.
     * 
     * This method approaches the problem as one of depth-first connected
     * components search
     * @param grid, the given grid.
     * @return the number of islands.
     */

    public int numIslands(char[][] grid) {
        // Our count to return
        int count = 0;
        
        // Dimensions of the given graph
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        
        // Iterate over the entire given grid
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }    
        return count;
    }
    
    /**
     * Marks the given site as visited, then checks adjacent sites.
     * 
     * Or, Marks the given site as water, if land, then checks adjacent sites.
     * 
     * Or, Given one coordinate (i,j) of an island, obliterates the island
     * from the given grid, so that it is not counted again.
     * 
     * @param i, the row index of the given grid
     * @param j, the column index of the given grid
     */

    private void DFSMarking(char[][] grid, int i, int j) {
        // Check for invalid indices and for sites that aren't land
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        
        // Mark the site as visited
        grid[i][j] = '0';
        
        // Check all adjacent sites
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

}
