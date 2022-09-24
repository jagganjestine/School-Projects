/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultimatettt;

public abstract class Player {

	protected boolean isValid = false; // there is an empty space for a player to make another move
	protected UltimateTicTacToeBoard board;
	protected GamePiece thisPlayersPiece;

	/**
	 * Constructor that passes through the UltimateTicTacToeBoard object and the
	 * GamePiece object to allow a human player to make a move on it.
	 * 
	 * @param b - board used to play the game
	 * @param p - game piece used (x or o)
	 */
	public Player(UltimateTicTacToeBoard b, GamePiece p) {
		board = b;
		thisPlayersPiece = p;
	}

	/**
	 * Player makes a move on the board (must be valid)
	 * @param moveRestrictions - parameters of previous move
	 * @return int[] of parameters of the move just made
	 */
	public abstract int[] makeAMove(int[] moveRestrictions);
	
	/**
	 * Boolean method to check if a player is allowed to make a move.
	 * @param board - Ultiamte TTT board
	 * @param bigRow - row of TTT board
	 * @param bigCol - row of TTT board
	 * @param innerRow - row of game piece in TTT board
	 * @param innerCol - col of game piece in TTT board
	 * @return isValid - if the move is valid (empty space and board not yet won)
	 */
	public boolean checkValidity(UltimateTicTacToeBoard board, int bigRow, int bigCol, int innerRow, int innerCol) {
		if (board.getPieceAt(bigRow, bigCol, innerRow, innerCol).getXorO().equals("_") && board.getTTTBoard(bigRow, bigCol).getWinner() == "_") {
			return true;
		}
		return false;
	}
	
}