/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultimatettt;

/**
 *
 * @author JAGGAN-TWR
 */
public class GamePiece {

	private String XorO;

	/**
	 * Constructor to initialize XorO variable
	 * @param exoh - X or O
	 */
	public GamePiece(String exoh) {
		XorO = exoh;
	}

	/**
	 * setter method to set the value of the game piece
	 * @param exoh - either X or O
	 */
	public void setXorO(String exoh) {
		XorO = exoh;
	}

	/**
	 * getter method to return either X or O
	 * @return XorO - either X or O
	 */
	public String getXorO() {
		return XorO;
	}

}