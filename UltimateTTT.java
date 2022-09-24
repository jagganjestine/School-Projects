
package ultimatettt;

import java.util.*;

/**
 *
 * @author JAGGAN-TWR
 */
public class UltimateTTT {
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Player xPlayer = null;
		Player oPlayer = null;
		UltimateTicTacToeBoard board = new UltimateTicTacToeBoard();
		
		UltimateTTTGame game = new UltimateTTTGame(board, xPlayer, oPlayer);
		game.playGame();

	}

}