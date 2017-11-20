package fb.matrix;

public class Matrix {
	
	public static void main(String[] args) {
		int [] [] num = {
				//0, 1, 2, 3
				{ 1, 2, 3, 4 },
				{ 1, 5, 3, 4 },
				{ 1, 2, 3, 4 },
				{ 1, 2, 3, 4 },
		};
		int rowTotal = 0;
		
		for(int i = 0; i < num.length; i++) {
			rowTotal += num[1][i];
		}
		System.out.println(rowTotal);
		
		int total = sum(num);
		System.out.println(total);
	}
	
	//sum of the whole matrix
	public static int sum(int [][] values) {
		int total = 0;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length; j++) {
				total += values[i][j];
			}
		}
		return total;
	}

}

//https://www.youtube.com/watch?v=I2wu-ELvJDY

