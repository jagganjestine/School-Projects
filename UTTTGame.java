package UltimateTicTacToe;
//Jaggan Jestine JAJ180010 2336.003


//game board commands
import java.util.*;

public class UTTTGame {

    static Scanner console = new Scanner(System.in);
    private static Board board;
    private static ComputerPlayer[] p = new ComputerPlayer[2];
    private static HumanPlayer[] h = new HumanPlayer[2];
    private static String name = "TicTacToe";
    private static String[] marks = {"X", "O"};
    private static int gameRowSize = 9;
    private static int gameColSize = 9;
    private static String winner = "";
    static int option = 0;
    static String endOption = "";
    static int currentPlayerIndex = -1;
    static int block;
    static int implementT0;
    static int implementT1;
    static int implementT2;
    static int implementT3;
    static int implementT4;
    static int implementT5;
    static int implementT6;
    static int implementT7;
    static int implementT8;

    public UTTTGame() {
        setBoard();
    }

    private void setBoard() {
        this.board = new Board(gameRowSize, gameColSize, "UTTTGame");
    }

    public static void start() {
        optionMenu();//choose a game mode
    }

    static void optionMenu() {
        System.out.println();
        System.out.println("Please select one of the following options: ");
        System.out.println("1: Player vs AI");
        System.out.println("2: AI vs AI");
        System.out.println("3: Player vs Player");
        System.out.println();
        System.out.print("Enter: ");
        option = console.nextInt();

        switch (option) {
            case 1:     //Player vs AI
                System.out.println();
                currentPlayerIndex = 0;//starts with human user
                lockBlock();
                setPlayerVsAI(); //set players for Player vs AI game 
                playerVsAI(); //start Player vs AI game
                break;
            case 2:     //AI vs AI
                System.out.println();
                lockBlock();
                setAIvsAI(); //set players for AI vs AI game         
                AIvsAI(); //start AI vs AI game
                break;
            case 3:     //Player vs Player
                System.out.println();
                lockBlock();
                setPlayerVsPlayer(); //set players for Player vs Player game
                playerVsPlayer(); //start Player vs Player game
                gameOver();
                break;
            default:    //loops menu until valid option is chosen
                optionMenu(); //loops menu until valid option is chosen
        }
    }

    //Player vs AI
    static void playerVsAI() {
        do {
            if (currentPlayerIndex == 1) {

                board.AImakeMove(p[currentPlayerIndex].getMark(), p[currentPlayerIndex].randomNumber(gameRowSize), p[currentPlayerIndex].randomNumber(gameColSize)); //AI makes move
                board.print();
            }
            if (currentPlayerIndex == 0) //check for valid input
            {
                System.out.println();
                System.out.println("Block: " + block);
                System.out.println("Player: " + marks[currentPlayerIndex]);
                //user input for a valid row number within the range
                System.out.println("Please enter a Row number (0 - 8)");
                int row = console.nextInt(); //initialize user row input
                if (row < 0 || row > 8) //checks whether input is within the range
                {
                    do {
                        System.out.println("OUT OF BOUNDS PLEASE TRY AGAIN ");
                        System.out.println("Please enter a Row number (0 - 8)");
                        row = console.nextInt();
                    } while (row < 0 || row > 8);
                }

                // user input for a valid col number within the range
                System.out.println("Please enter a Col number (0 - 8)");
                int col = console.nextInt(); //initialize user col input
                if (col < 0 || col > 8) //checks whether input is within the range
                {
                    do {
                        System.out.println("OUT OF BOUNDS PLEASE TRY AGAIN ");
                        System.out.println("Please enter a Col number (0 - 8)");
                        col = console.nextInt();
                    } while (col < 0 || col > 8);
                }

                //make the move
                board.makeMove(h[currentPlayerIndex].getMark(), row, col); //Player makes move 
                board.print();

            }
            checkBlocks();
            switchPlayer();
        }while(!gameOver());

    }
    //set up the player and AI name and mark on the board
    private static void setPlayerVsAI() {
        if (currentPlayerIndex == 1) {
            for (int i = 0; i < p.length; i++) {
                ComputerPlayer pl = new ComputerPlayer("AI", "X");
                p[i] = pl;
            }
            for (int i = 0; i < h.length; i++) {
                HumanPlayer hu = new HumanPlayer("Human", "O");
                h[i] = hu;
            }
        }
        if (currentPlayerIndex == 0) {
            for (int i = 0; i < h.length; i++) {
                HumanPlayer hu = new HumanPlayer("Human", "X");
                h[i] = hu;
            }
            for (int i = 0; i < p.length; i++) {
                ComputerPlayer pl = new ComputerPlayer("AI", "O");
                p[i] = pl;
            }
        }

    }

    //AI vs AI
    static void AIvsAI() {
        do {
            switchPlayer();
            System.out.println();
            System.out.println("Player: " + marks[currentPlayerIndex]);
            board.AImakeMove(p[currentPlayerIndex].getMark(), p[currentPlayerIndex].randomNumber(gameRowSize), p[currentPlayerIndex].randomNumber(gameColSize));
            board.print();
            checkBlocks();
        } while (!gameOver());
    }
    //set up both the AI players name and mark on the board
    private static void setAIvsAI() {
        for (int i = 0; i < p.length; i++) {
            ComputerPlayer pl = new ComputerPlayer("player" + i + 1, marks[i]);
            p[i] = pl;
        }
    }

    //Player vs Player
    static void playerVsPlayer() {
        do {
            System.out.println();
            System.out.println("Block: " + block);
            if (currentPlayerIndex == 1) {
                System.out.println("Player: " + marks[currentPlayerIndex]);
                //user input for a valid row number within the range
                System.out.println("Please enter a Row number (0 - 8)");
                int row = console.nextInt(); //initialize user row input
                if (row < 0 || row > 8) //checks whether input is within the range
                {
                    do {
                        System.out.println("OUT OF BOUNDS PLEASE TRY AGAIN ");
                        System.out.println("Please enter a Row number (0 - 8)");
                        row = console.nextInt();
                    } while (row < 0 || row > 8);
                }

                // user input for a valid col number within the range
                System.out.println("Please enter a Col number (0 - 8)");
                int col = console.nextInt(); //initialize user col input
                if (col < 0 || col > 8) //checks whether input is within the range
                {
                    do {
                        System.out.println("OUT OF BOUNDS PLEASE TRY AGAIN ");
                        System.out.println("Please enter a Col number (0 - 8)");
                        col = console.nextInt();
                    } while (col < 0 || col > 8);
                }

                //make the move
                board.makeMove(h[currentPlayerIndex].getMark(), row, col); //Player makes move 
                board.print();
            }
            if (currentPlayerIndex == 0) //check for valid input
            {
                System.out.println("Player: " + marks[currentPlayerIndex]);
                //user input for a valid row number within the range
                System.out.println("Please enter a Row number (0 - 8)");
                int row = console.nextInt(); //initialize user row input
                if (row < 0 || row > 8) //checks whether input is within the range
                {
                    do {
                        System.out.println("OUT OF BOUNDS PLEASE TRY AGAIN ");
                        System.out.println("Please enter a Row number (0 - 8)");
                        row = console.nextInt();
                    } while (row < 0 || row > 8);
                }

                // user input for a valid col number within the range
                System.out.println("Please enter a Col number (0 - 8)");
                int col = console.nextInt(); //initialize user col input
                if (col < 0 || col > 8) //checks whether input is within the range
                {
                    do {
                        System.out.println("OUT OF BOUNDS PLEASE TRY AGAIN ");
                        System.out.println("Please enter a Col number (0 - 8)");
                        col = console.nextInt();
                    } while (col < 0 || col > 8);
                }

                //make the move
                board.makeMove(h[currentPlayerIndex].getMark(), row, col); //Player makes move 
                board.print();
            }
            switchPlayer();
            checkBlocks();
        } while (!gameOver());
    }
    
     //set up the player1 and player2 name and mark on the board
    static void setPlayerVsPlayer() {
        for (int i = 0; i < h.length; i++) {
            HumanPlayer hu = new HumanPlayer("player" + i + 1, marks[i]);
            h[i] = hu;
        }
    }
    
    //funtion recieves the player input select which block to start with, or switch to
    static void lockBlock() {
        System.out.println("Please enter a block: ");
        block = console.nextInt();

    }
    
    //switches the player index
    private static void switchPlayer() {
        if (currentPlayerIndex == -1 || currentPlayerIndex == 1) {
            currentPlayerIndex = 0;
        } else {
            currentPlayerIndex = 1;
        }

    }
    
    // if invalid move is recieved then the player must redo the move by calling the appropriate method
    static void redoMove() {
        switch (option) {
            case 1:
                playerVsAI(); //redo Player/AI move
                break;
            case 2:
                AIvsAI(); //redo AI move    
                break;
            case 3:
                playerVsPlayer(); //redo move
                break;
        }
    }

    //game over method is called when the whole board recieves a winner, or is full, resulting in a tie
    private static boolean gameOver() {
        if (isWinner()) {
            System.out.println("GAME OVER");
            System.out.println("WINNER: " + winner);
            System.out.println("THANK YOU FOR PLAYING");
            end();
            return true;
        } else if (board.isFull()) {
            System.out.println("GAME OVER");
            System.out.println("TIE");
            System.out.println("THANK YOU FOR PLAYING");
            end();
            return true;
        } else {
            return false;
        }
    }
    
    // function calls the BlockWinner methods from board class
    static void checkBlocks() {
        if (board.ifBlock0Winner()) {
            if(implementT0 == 0) { //if the method has been implemented, then it will set the variable to 1, which is used for the make moveMove method in Board class
                Board.block0TakeOver(Board.winner);
                implementT0 = 1;
                if (isWinner()) 
                    gameOver();
            } else {
                Board.block0TakeOver(Board.winner);
            }
        }
        if (board.ifBlock1Winner()) {
            if (implementT1 == 0) {//if the method has been implemented, then it will set the variable to 1, which is used for the make moveMove method in Board class
                Board.block1TakeOver(Board.winner);               
                implementT1 = 1;
                if (isWinner()) 
                    gameOver();
                

            } else {
                Board.block1TakeOver(Board.winner);
            }
        }
        if (board.ifBlock2Winner()) {
            if (implementT2 == 0) {//if the method has been implemented, then it will set the variable to 1, which is used for the make moveMove method in Board class
                Board.block2TakeOver(Board.winner);
                implementT2 = 1;
                if (isWinner()) 
                    gameOver();
                

            } else {
                Board.block2TakeOver(Board.winner);
            }
        }
        if (board.ifBlock3Winner()) {
            if (implementT3 == 0) {//if the method has been implemented, then it will set the variable to 1, which is used for the make moveMove method in Board class
                Board.block3TakeOver(Board.winner);
                implementT3 = 1;
                if (isWinner()) 
                    gameOver();
                

            } else {
                Board.block3TakeOver(Board.winner);
            }
        }
        if (board.ifBlock4Winner()) {
            if (implementT4 == 0) {//if the method has been implemented, then it will set the variable to 1, which is used for the make moveMove method in Board class
                Board.block4TakeOver(Board.winner);
                implementT4 = 1;
                if (isWinner()) 
                    gameOver();
                

            } else {
                Board.block4TakeOver(Board.winner);
            }
        }
        if (board.ifBlock5Winner()) {
            if (implementT5 == 0) {//if the method has been implemented, then it will set the variable to 1, which is used for the make moveMove method in Board class
                Board.block5TakeOver(Board.winner);
                implementT5 = 1;
                if (isWinner()) 
                    gameOver();
                

            } else {
                Board.block5TakeOver(Board.winner);
            }
        }
        if (board.ifBlock6Winner()) {
            if (implementT6 == 0) {//if the method has been implemented, then it will set the variable to 1, which is used for the make moveMove method in Board class
                Board.block6TakeOver(Board.winner);
                implementT6 = 1;
                if (isWinner()) 
                    gameOver();
                

            } else {
                Board.block6TakeOver(Board.winner);
            }
        }
        if (board.ifBlock7Winner()) {
            if (implementT7 == 0) {//if the method has been implemented, then it will set the variable to 1, which is used for the make moveMove method in Board class
                Board.block7TakeOver(Board.winner);
                implementT7 = 1;
                if (isWinner()) 
                    gameOver();
                

            } else {
                Board.block7TakeOver(Board.winner);
            }
        }
        if (board.ifBlock8Winner()) {
            if (implementT8 == 0) {//if the method has been implemented, then it will set the variable to 1, which is used for the make moveMove method in Board class
                Board.block8TakeOver(Board.winner);
                implementT8 = 1;
                if (isWinner()) 
                    gameOver();
                

            } else {
                Board.block8TakeOver(Board.winner);
            }
        }
    }
    //checks for whole board winner
    private static boolean isWinner() {
        if (board.gameWinner()) {
            winner = Board.gameWinner;
            return true;
        }
        return false;
    }
    //exits the game
    private static void end() {
        System.out.println();

        System.exit(0);

    }
}
