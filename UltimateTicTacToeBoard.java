/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultimatettt;

public class UltimateTicTacToeBoard implements Iterable {

	private TicTacToeBoard[][] board;

	/**
	 * Constructor that initializes board
	 */
	public UltimateTicTacToeBoard() {
		board = new TicTacToeBoard[3][3];
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 3; ++col) {
				board[row][col] = new TicTacToeBoard();
			}
		}
	}

	/**
	 * Get piece at specified row and col of the board and cell
	 * @param rowBoard - the row of the tic tac toe board
	 * @param columnBoard - the column of the tic tac toe board
	 * @param rowIn - the row of the square at the specified tic tac toe board
	 * @param columnIn - the column of the square at the specified tic tac toe board
	 * @return game piece at that specified location
	 */
	public GamePiece getPieceAt(int rowBoard, int columnBoard, int rowIn, int columnIn) {
		return board[rowBoard][columnBoard].getPieceAt(rowIn, columnIn);
	}

	/**
	 * Set piece at specified row and col of board and cell
	 * @param rowBoard - the row of the tic tac toe board
	 * @param columnBoard - the column of the tic tac toe board
	 * @param rowIn - the row of the square at the specified tic tac toe board
	 * @param columnIn - the column of the square at the specified tic tac toe board
	 * @param setTo - the game piece the specified square will be set to
	 */
	public void setPieceAt(int rowBoard, int columnBoard, int rowIn, int columnIn, GamePiece setTo) {
		board[rowBoard][columnBoard].setPieceAt(rowIn, columnIn, setTo);
	}
	
	/**
	 * Get tic tac toe board with specified r and c
	 * @param r - row
	 * @param c - col
	 * @return tic tac toe board
	 */
	public TicTacToeBoard getTTTBoard(int r, int c) {
		return board[r][c];
	}
	
	/**
	 * Get line of the board (one row across the entire board)
	 * @param row - row index (from 0 to 8)
	 * @return row in string format
	 */
	private String getLine(int row) {
		int R = row/3;
		return getTTTBoard(R, 0).getRow(row-R*3) + " | " + getTTTBoard(R, 1).getRow(row-R*3) + " | " + getTTTBoard(R, 2).getRow(row-R*3) + "\n";
	}
	
	/**
	 * toString method to return data of the board in string format
	 * return s - data of board in string form
	 */
	public String toString() {
		String s = "    0 1 2   3 4 5   6 7 8\n\n";
		for (int r = 0; r < 9; r++) {
			s += r + "   " + getLine(r);
			if (r % 3 == 2 && r != 8) s += "    ---------------------\n";
		}
		s += "\n";
		return s;
	}
	
	/**
	 * Iterator method
	 * Defines hasNext() and next() so the board can be used as an iterator
	 * @return iter
	 */
	@Override
    public Iterator<TicTacToeBoard> iterator() {
        Iterator<TicTacToeBoard> iter = new Iterator<TicTacToeBoard>() {

            private int currentIndex = 0;

            /**
             * Defines hasNext() method of the board iterator
             * @return if the UTTT board has another tic tac toe board
             */
            @Override
            public boolean hasNext() {
                return currentIndex < 9;
            }

            /**
             * Defines next() method of the board iterator
             * @return the next tic tac toe board
             */
            @Override
            public TicTacToeBoard next() {
                return board[currentIndex / 3][currentIndex++ % 3];
            }

        };
        return iter;
    }

}