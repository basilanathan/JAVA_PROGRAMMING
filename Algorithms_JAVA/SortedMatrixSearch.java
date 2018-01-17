package algosJava;

import helpers.AssortedMethods;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * Given a M X N matrix in which each row and each column
 * is sorted in ascending order, write a method to find
 * and element.
 * 
 * </br>
 * 
 * Time: O(N + M)
 * Time: O( log( rows * cols ) )
 * 
 * By looking for a suitable row first and then doing a binary search, you end up with a runtime 
 * complexity of O( rows + log( cols ) ); whereas, if you treat the whole search space as a single 
 * array, you end up with a runtime complexity of O( log( rows * cols ) ). So, to put it in context, 
 * imagine you have a 2-dimensional array consisting of 1-million rows and 10-columns, then you'll 
 * end up with the following:

1000000 + log( 10 ) = 1000001

log( 1000000 * 10 ) = 7

Your approach will have 1000001 operations, whereas the latter will have only 7.
 *
 */

public class SortedMatrixSearch {
	
	static boolean FindElement(int[][] matrix, int value) {
		if(matrix.length == 0 || matrix[0].length == 0) return false;
		int row = 0;
		int col = matrix[0].length - 1;
		
		while(row < matrix.length && col >= 0) {
			if (matrix[row][col] == value) {
				return true;
			} else if(matrix[row][col] > value) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}
	
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int start = 0, rows = matrix.length, cols = matrix[0].length;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            } 
            if (matrix[mid / cols][mid % cols] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		int M = 10;
		int N = 5;
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = 10 * i + j;
			}
		}
		
		AssortedMethods.printMatrix(matrix);
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				int v = 10 * i + j;
				//System.out.println(v + ": " + FindElement(matrix, v));
				System.out.println(v + ": " + searchMatrix(matrix, v));

			}
		}
		
	}

}
