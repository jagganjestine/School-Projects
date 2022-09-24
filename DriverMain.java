package UltimateTicTacToe;
//Jaggan Jestine JAJ180010 2336.003

/*

Analysis & Design:
The program needs to implement a Object Array to play Ultimate tic tac toe, where there are 9 subgames going on in the whole game board. Once 3 sub games in a row have been won, the whole game has been won.
The rules are a little different than regular tic tac toe and require some special methods and cases to have a succesful game.
Through many test cases the best possible way to implement the game was to have the subwinner of each block of the game, take over the entire block. That way, it would be easier to check for the whole game winner via check methods,
as well as visually appealing. Throughout the program I have added small comments on how the various methods work with each other and help complete the game. Enjoy!
*/
public class DriverMain {

    public static void main(String[] args) {
        UTTTGame game = new UTTTGame();
        game.start();
    }

}
