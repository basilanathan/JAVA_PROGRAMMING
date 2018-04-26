package fb.leetcode;

import java.util.HashSet;

/**
 * 
 * @author basila
 * 
 * https://leetcode.com/problems/valid-sudoku/discuss/15450/Shared-my-concise-Java-code
 *
 */

public class ValidSudoku {
	
	//traverse a matrix
	
	public boolean isValidSudoku(char[][] board) {
	    for(int i = 0; i<9; i++){
	        HashSet<Character> rows = new HashSet<Character>();
	        HashSet<Character> columns = new HashSet<Character>();
	        HashSet<Character> cube = new HashSet<Character>();
	        for (int j = 0; j < 9;j++){
	            if(board[i][j]!='.' && !rows.add(board[i][j]))
	                return false;
	            if(board[j][i]!='.' && !columns.add(board[j][i]))
	                return false;
	            int RowIndex = 3*(i/3);
	            int ColIndex = 3*(i%3);
	            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
	                return false;
	        }
	    }
	    return true;
	}

}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0 || board.length != board[0].length) {
            return false;
        }
        HashSet<Character> row,col,block;
        int n = board.length;
    
        for (int i = 0; i < n; i++) {
            row = new HashSet<Character>();
            col = new HashSet<Character>();
            block = new HashSet<Character>();
            for (int j = 0; j < n; j++) {
                //Check row
                if (!row.contains(board[i][j])) {
                    row.add(board[i][j]);
                } else if (board[i][j] != '.'){
                    return false;
                }
                //Check col
                if (!col.contains(board[j][i])) {
                    col.add(board[j][i]);
                } else if (board[j][i] != '.'){
                    return false;
                }
                //check block
                int c = j % 3 + 3 * (i % 3);//make use of how i and j increases
                int r = j / 3 + 3 * (i / 3);
                if (!block.contains(board[r][c])) {
                    block.add(board[r][c]);
                } else if (board[r][c] != '.') {
                    return false;
                }
            }
        }

        return true;
    }
}
