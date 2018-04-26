package fb.leetcode;

/**
 * 
 * @author basila
 * 
 * https://leetcode.com/problems/diagonal-traverse/description/
 *
 */

//public class MatrixDiagonalTraverse {
//	
//
//    public int[] findDiagonalOrder(int[][] matrix) {
//        if (matrix.length == 0) return new int[0];
//        int r = 0, c = 0, m = matrix.length, n = matrix[0].length, arr[] = new int[m * n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = matrix[r][c];
//            if ((r + c) % 2 == 0) { // moving up
//                if      (c == n - 1) { r++; }
//                else if (r == 0)     { c++; }
//                else            { r--; c++; }
//            } else {                // moving down
//                if      (r == m - 1) { c++; }
//                else if (c == 0)     { r++; }
//                else            { r++; c--; }
//            }   
//        }   
//        return arr;
//    }
//
//}


//https://careercup.com/question?id=4943998208704512
public class MatrixDiagonalTraverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] mat = { {1,2,3,4,5},
						{6,7,8,9,10},
						{11,12,13,14,15},
						{16,17,18,19,20}
					};
		printMatrixDiagonally(mat);

	}

	private static void printMatrixDiagonally(int[][] mat) {
		
		//Down side
		int col = 0;
		for(int row = 0; row < mat.length; row++){
			diagonally(mat, row, col);
			System.out.print("\n");
		}
		//Right side
		int row = mat.length - 1; //3
		for(col = 1; col < mat[row].length; col++){
			diagonally(mat, row, col);
			System.out.print("\n");
		}
		
	}
	//using recursion printing matrix diagonally
	private static void diagonally(int[][] mat, int row, int col) {
		
		//Bundary check
		if(row < 0 || col < 0 || row >= mat.length || col >= mat[0].length){
			return;
		}
		System.out.print(mat[row][col]+" ");
		diagonally(mat, --row, ++col);
		
	}
}

//output:
//aej
//bfk
//cg
//di
//h
public class MatrixDiagonalTraverse
{
  public static void main(String [] args)
  {
    char [][] arr = {
                    {'a','b','c',' '},
                    {'d','e','f','g'},
                    {'h','i','j','k'}
                  };
    boolean [] seen = new boolean[256];
    for(int i = 0; i < arr.length; i++)
    {
      for(int j = 0; j < arr.length; j++)
      {
        char num = arr[i][j];
        if(!seen[num])
        {
          int k = 0;
          while(i+k < arr.length && j+k < arr[0].length)
          {
            seen[arr[i+k][j+k]] = true;
            System.out.print(arr[i+k][j+k]);
            k++;
          }
          System.out.println();
        }
      }
    }
  }
}
