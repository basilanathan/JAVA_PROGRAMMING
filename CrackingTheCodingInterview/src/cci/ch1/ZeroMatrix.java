package cci.ch1;



public class ZeroMatrix {
	
	public static void main(String[] args) {
		int [][] matrix = {
				{0,  2,  3,  4},
				{5,  6,  7,  8},
				{9, 10, 0, 12},
				{13, 14, 15, 16}
		};
		
		setZeroes(matrix);
		System.out.println();
		ZeroMatrix.printMatrix(matrix);
	}
	public static void setZeroes(int[][] matrix) {
		//using estra space
		
		boolean row[] = new boolean[matrix.length]; //row = [false, false, false]
		boolean column[] = new boolean[matrix[0].length]; //column = [false, false, false]
		
		//store the row and column index with value 0
		for(int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					row[i] = true; //set the entire row to true
					column[j] = true; //set the entire column to true
				}
			}
		}
		
		//nullify the row
		for(int i = 0; i < row.length; i++) {
			if(row[i]) nullifyRow(matrix, i);
		}
		
		//nullify column
		for(int j = 0; j < column.length; j++) {
			if (column[j]) nullifyCloumn(matrix, j); 
				
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
