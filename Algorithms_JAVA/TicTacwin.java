package algosJava;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * Tic Tac Win: Design an algorithm to figure out if someone
 * has won a game of tic-tac-toe.
 * 
 *  
 * </br>
 *
 */

public class TicTacwin {
	
	enum Piece { Empty, Red, Blue };
	
	//Solution 1
	public static int convertBoardToInt(Piece[][] board) {
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int value = board[i][j].ordinal();
				sum = sum * 3 + value;
			}
		}
		return sum;
	}
	
	//Solution 2
	public static Piece hasWon(Piece[][] board) {
		for (int i = 0; i < board.length; i++) {
			/* Check Rows */
			if (hasWinner(board[i][0], board[i][1], board[i][2])) {
				return board[i][0];
			}

			/* Check Columns */
			if (hasWinner(board[0][i], board[1][i], board[2][i])) {
				return board[0][i];
			}
		}

		/* Check Diagonal */
		if (hasWinner(board[0][0], board[1][1], board[2][2])) {
			return board[0][0];
		}
		
		if (hasWinner(board[0][2], board[1][1], board[2][0])) {
			return board[0][2];
		}
		
		return Piece.Empty;
	}
	
	public static boolean hasWinner(Piece p1, Piece p2, Piece p3) {
		if (p1 == Piece.Empty) {
			return false;
		}
		return p1 == p2 && p2 == p3;
	}
	
	public static void main(String[] args) {
		Piece[][] board = { 
				{Piece.Empty, Piece.Empty, Piece.Empty},
				{Piece.Empty, Piece.Empty, Piece.Empty},
				{Piece.Blue, Piece.Blue, Piece.Blue}};
		
		int v = convertBoardToInt(board);
		System.out.println(v);
	}

}
