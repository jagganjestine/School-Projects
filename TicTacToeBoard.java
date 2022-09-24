/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultimatettt;

/**
 *
 * @author JAGGAN-TWR
 */
public class TicTacToeBoard {

	private GamePiece[][] board;
	private String winner = "_"; // _ = empty, X = X player, O = O player

	/**
	 * TicTacToeboard constructor-Constructor that initializes board to a 3x3
	 * array of game pieces
	 */
	public TicTacToeBoard() {
		board = new GamePiece[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = new GamePiece("_");
			}
		}
	}

	/**
	 * Get game piece at specified row and col
	 * @param row - the row of the board
	 * @param column - the column of the board
	 * @return the game piece at that row and column
	 */
	public GamePiece getPieceAt(int row, int column) {
		return board[row][column];
	}

	/**
	 * Sets piece at specified row and col
	 * @param row - the row of the square to be set
	 * @param column - the column of the square to be set
	 * @param setTo - the game piece the square will be set to
	 */
	public void setPieceAt(int row, int column, GamePiece setTo) {
		board[row][column] = setTo;
	}
	
	/**
	 * Get a row of the board in string format
	 * @param row - row index number
	 * @return row in string form
	 */
	public String getRow(int row) {
		return board[row][0].getXorO() + " " + board[row][1].getXorO() + " " + board[row][2].getXorO();
	}
	
	/**
	 * Get the winner of the board
	 * @return winner (_ if no winner, X, or O)
	 */
	public String getWinner() {
		return winner;
	}
	
	/**
	 * Set winner of the board
	 * @param s - winner (X or O)
	 */
	public void setWinner(String s) {
		winner = s;
	}

}