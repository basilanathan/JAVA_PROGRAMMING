package algosJava;

/**
 * 
 * @author basila
 * @date 11/26/2017
 * 
 * Time: O(N^2) best we can do since any algorithm must touch N^2 elements.
 */

//	Input:
//	 1  2  3  4 
//	 5  6  7  8 
//	 9 10 11 12 
//	13 14 15 16 
//
//	Output:
//	 4  8 12 16 
//	 3  7 11 15 
//	 2  6 10 14 
//	 1  5  9 13

public class RotateMatrix {
	
	public static void main(String[] args) {
		int [][] matrix = {
				{1,  2,  3,  4},
				{5,  6,  7,  8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		
		rotate(matrix);
		System.out.println();
		RotateMatrix.printMatrix(matrix);
	}
	
	public static boolean rotate(int[][] matrix) {
		if(matrix.length == 0 || matrix.length != matrix[0].length) return false; //// Not a square
		int n = matrix.length;
		for(int layer = 0; layer < n/2; layer++) { //4 x 4 matrix will have 4/2 = 2 cycles
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				
				int top = matrix[first][i]; // save top

				// left -> top
				matrix[first][i] = matrix[last-offset][first]; 			

				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset]; 

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last]; 

				// top -> right
				matrix[i][last] = top; // right <- saved top
				
			}
		}
		return true;
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] < 10 && matrix[i][j] > -10) {
					System.out.print(" ");
				}
//				if (matrix[i][j] < 100 && matrix[i][j] > -100) {
//					System.out.print(" ");
//				}
//				if (matrix[i][j] >= 0) {
//					System.out.print(" ");
//				}
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
	}

}
