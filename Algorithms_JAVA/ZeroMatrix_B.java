package algosJava;

/**
 * 
 * @author basila
 * @date 11/26/2017
 * 
 * Space O(1)
 */

public class ZeroMatrix_B {
	
	public static void main(String[] args) {
		int [][] matrix = {
				{0,  2,  3,  4},
				{5,  6,  7,  8},
				{9, 10, 0, 12},
				{13, 14, 15, 16}
		};
		
		setZeros(matrix);
		System.out.println();
		ZeroMatrix.printMatrix(matrix);
	}
	
	public static void setZeros(int[][] matrix) {
		boolean rowHasZero = false;
		boolean columnHasZero = false;
		
		//check is first row has zero
		for(int j = 0; j < matrix[0].length; j++) {
			if(matrix[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}
		
		//check if first column has zero
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				columnHasZero = true;
				break;
			}
		}
		
		//check for zeros in the rest of the array
		for(int i = 1; i < matrix.length; i++) {
			for(int j = 1; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0; //row
					matrix[0][j] = 0; //column
				}
			}
		}
		
		//nullify row based on the value of the first column
		for (int i = 1; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}
		}
		//nullify column based on the value of the first row
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				nullifyCloumn(matrix, j);
			}
		}
		
		//nullify first row
		if (rowHasZero) {
			nullifyRow(matrix, 0);
		}
		
		//nullify first column
		if (columnHasZero) {
			nullifyCloumn(matrix, 0);
		}
	}
	
	public static void nullifyRow(int[][] matrix, int row) {
		for(int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}
	}
	
	public static void nullifyCloumn(int[][] matrix, int column) {
		for(int i = 0; i < matrix.length; i++) {
			matrix[i][column] = 0;
		}
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
