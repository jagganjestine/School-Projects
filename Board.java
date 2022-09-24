package UltimateTicTacToe;
//Jaggan Jestine JAJ180010 2336.003

//contains main board methods to find winner and initialize board
import java.util.*;

public class Board {

    static Scanner console = new Scanner(System.in);
    private static Box[] boxes;
    private static String[] copy;
    private String name;
    static String winner = "";
    static String gameWinner = "";
    private static int boardRowSize;
    private static int boardColSize;
    Board() {
        this(9, 9, "9*9 board");
    }

    Board(int rowSize, int colSize, String name) {
        this.setName(name);
        this.setSize(rowSize, colSize);
    }
    
    //sets the size of the board
    private void setSize(int row, int col) {
        if (row < 9 || col < 9) {
        System.out.println("min board size is 9*9");
        } else {
            this.boardColSize = col;
            this.boardRowSize = row;
            init();
            initCopy();
            }
        
    }
    //sets the name of the board 
    private void setName(String name) {
        this.name = name;

    }

    //actual object array that is played on and printed
    public static void init() {
        boxes = new Box[boardColSize * boardRowSize];
        for (int i = 0; i < boxes.length; i++) {
            Box b = new Box(i / boardColSize, i % boardColSize);
            boxes[i] = b;
        }
        print();
    }

    //does not get printed into the console, is used behind the scenes of the program, and only used for checking purposes
    public static void initCopy() {
        copy = new String[boardColSize * boardRowSize];
        for (int i = 0; i < copy.length; i++) {
            String b = "-";
            copy[i] = b;
        }
    }


    //prints the object array that is played on
    public static void print() {
        System.out.println();
        System.out.println("\t\t       WELCOME TO ULTIMATE TIC TAC TOE");
        System.out.println();
        System.out.println("\t\t\t         BOARD MAP");
        System.out.println("BOARD# 0: (0,0) (0,1) (0,2) 	BOARD# 1: (0,3) (0,4) (0,5) 	BOARD# 2: (0,6) (0,7) (0,8) \n"
                + "BOARD# 0: (1,0) (1,1) (1,2) 	BOARD# 1: (1,3) (1,4) (1,5)	BOARD# 2: (1,6) (1,7) (1,8) \n"
                + "BOARD# 0: (2,0) (2,1) (2,2) 	BOARD# 1: (2,3) (2,4) (2,5)	BOARD# 2: (2,6) (2,7) (2,8)  \n"
                + "\n"
                + "BOARD# 3: (3,0) (3,1) (3,2) 	BOARD# 4: (3,3) (3,4) (3,5)	BOARD# 5: (3,6) (3,7) (3,8) \n"
                + "BOARD# 3: (4,0) (4,1) (4,2) 	BOARD# 4: (4,3) (4,4) (4,5)	BOARD# 5: (4,6) (4,7) (4,8)  \n"
                + "BOARD# 3: (5,0) (5,1) (5,2) 	BOARD# 4: (5,3) (5,4) (5,5)	BOARD# 5: (5,6) (5,7) (5,8)  \n"
                + "\n"
                + "BOARD# 6: (6,0) (6,1) (6,2) 	BOARD# 7: (6,3) (6,4) (6,5)	BOARD# 8: (6,6) (6,7) (6,8)  \n"
                + "BOARD# 6: (7,0) (7,1) (7,2) 	BOARD# 7: (7,3) (7,4) (7,5)	BOARD# 8: (7,6) (7,7) (7,8)  \n"
                + "BOARD# 6: (8,0) (8,1) (8,2) 	BOARD# 7: (8,3) (8,4) (8,5)	BOARD# 8: (8,6) (8,7) (8,8)  ");
        System.out.println();
        System.out.println("\t\t\t         GAME BOARD");
        for (int i = 0; i < boxes.length; i++) {

            if (i != 0 && i % boardColSize == 0) {
                System.out.println();
            }
            if (i == 0) {
                System.out.print("\t\t        ");
            }
            if (i == 9) {
                System.out.print("\t\t        ");
            }
            if (i == 18) {
                System.out.print("\t\t        ");
            }
            if (i == 27) {
                System.out.println();
                System.out.print("\t\t        ");
            }
            if (i == 36) {
                System.out.print("\t\t        ");
            }
            if (i == 45) {
                System.out.print("\t\t        ");
            }
            if (i == 54) {
                System.out.println();
                System.out.print("\t\t        ");
            }
            if (i == 63) {
                System.out.print("\t\t        ");
            }
            if (i == 72) {
                System.out.print("\t\t        ");
            }
            if (i != 0 && i % boardColSize == 3) {
                System.out.print("      ");
            }
            if (i != 0 && i % boardColSize == 6) {
                System.out.print("      ");
            }
            boxes[i].print();

        }
        System.out.println();
    }
    
    //make the move if block isnt taken over and if its available, also sets the next players block
    void makeMove(String mark, int row, int col) {

        switch (UTTTGame.block) {
            case 0 -> {
                if (UTTTGame.implementT0 == 1) {
                    UTTTGame.lockBlock();
                }
                //tie
                if (UTTTGame.implementT0 != 1 && (!boxes[0].isAvailable() && !boxes[1].isAvailable() && !boxes[2].isAvailable()
                        && !boxes[9].isAvailable() && !boxes[10].isAvailable() && !boxes[11].isAvailable()
                        && !boxes[18].isAvailable() && !boxes[19].isAvailable() && !boxes[20].isAvailable())) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 0 || (row * boardRowSize + col) == 1 || (row * boardRowSize + col) == 2
                        || (row * boardRowSize + col) == 9 || (row * boardRowSize + col) == 10 || (row * boardRowSize + col) == 11
                        || (row * boardRowSize + col) == 18 || (row * boardRowSize + col) == 19 || (row * boardRowSize + col) == 20)) {
                    if ((row * boardRowSize + col) == 0) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 1) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 2) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 9) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 10) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 11) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 18) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 19) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 20) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    System.out.println("PLEASE CHOOSE A SQUARE THAT IS AVAILABLE AND WITHIN THE BLOCK");
                    UTTTGame.redoMove();
                }

            }
            case 1 -> {
                if (UTTTGame.implementT1 == 1) {
                    UTTTGame.lockBlock();
                }
                //tie
                if (UTTTGame.implementT1 != 1 && (!boxes[4].isAvailable() && !boxes[4].isAvailable() && !boxes[5].isAvailable()
                        && !boxes[12].isAvailable() && !boxes[13].isAvailable() && !boxes[14].isAvailable()
                        && !boxes[21].isAvailable() && !boxes[22].isAvailable() && !boxes[23].isAvailable())) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 3 || (row * boardRowSize + col) == 4 || (row * boardRowSize + col) == 5
                        || (row * boardRowSize + col) == 12 || (row * boardRowSize + col) == 13 || (row * boardRowSize + col) == 14
                        || (row * boardRowSize + col) == 21 || (row * boardRowSize + col) == 22 || (row * boardRowSize + col) == 23)) {
                    if ((row * boardRowSize + col) == 3) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 4) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 5) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 12) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 13) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 14) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 21) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 22) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 23) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    System.out.println("PLEASE CHOOSE A SQUARE THAT IS AVAILABLE AND WITHIN THE BLOCK");
                    UTTTGame.redoMove();
                }
            }

            case 2 -> {
                if (UTTTGame.implementT2 == 1) {
                    UTTTGame.lockBlock();
                }
                //tie
                if (UTTTGame.implementT2 != 1 && (!boxes[6].isAvailable() && !boxes[7].isAvailable() && !boxes[8].isAvailable()
                        && !boxes[15].isAvailable() && !boxes[16].isAvailable() && !boxes[17].isAvailable()
                        && !boxes[24].isAvailable() && !boxes[25].isAvailable() && !boxes[26].isAvailable())) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 6 || (row * boardRowSize + col) == 7 || (row * boardRowSize + col) == 8
                        || (row * boardRowSize + col) == 15 || (row * boardRowSize + col) == 16 || (row * boardRowSize + col) == 17
                        || (row * boardRowSize + col) == 24 || (row * boardRowSize + col) == 25 || (row * boardRowSize + col) == 26)) {
                    if ((row * boardRowSize + col) == 6) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 7) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 8) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 15) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 16) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 17) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 24) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 25) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 26) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    System.out.println("PLEASE CHOOSE A SQUARE THAT IS AVAILABLE AND WITHIN THE BLOCK");
                    UTTTGame.redoMove();
                }
            }
            case 3 -> {
                if (UTTTGame.implementT3 == 1) {
                    UTTTGame.lockBlock();
                }
                //tie
                if (UTTTGame.implementT3 != 1 && (!boxes[27].isAvailable() && !boxes[18].isAvailable() && !boxes[29].isAvailable()
                        && !boxes[36].isAvailable() && !boxes[37].isAvailable() && !boxes[38].isAvailable()
                        && !boxes[45].isAvailable() && !boxes[46].isAvailable() && !boxes[47].isAvailable())) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 27 || (row * boardRowSize + col) == 28 || (row * boardRowSize + col) == 29
                        || (row * boardRowSize + col) == 36 || (row * boardRowSize + col) == 37 || (row * boardRowSize + col) == 38
                        || (row * boardRowSize + col) == 45 || (row * boardRowSize + col) == 46 || (row * boardRowSize + col) == 47)) {
                    if ((row * boardRowSize + col) == 27) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 28) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 29) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 36) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 37) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 38) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 45) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 46) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 47) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    System.out.println("PLEASE CHOOSE A SQUARE THAT IS AVAILABLE AND WITHIN THE BLOCK");
                    UTTTGame.redoMove();
                }
            }
            case 4 -> {
                if (UTTTGame.implementT4 == 1) {
                    UTTTGame.lockBlock();
                }
                //tie
                if (UTTTGame.implementT4 != 1 && (!boxes[30].isAvailable() && !boxes[31].isAvailable() && !boxes[32].isAvailable()
                        && !boxes[39].isAvailable() && !boxes[40].isAvailable() && !boxes[41].isAvailable()
                        && !boxes[48].isAvailable() && !boxes[49].isAvailable() && !boxes[50].isAvailable())) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 30 || (row * boardRowSize + col) == 31 || (row * boardRowSize + col) == 32
                        || (row * boardRowSize + col) == 39 || (row * boardRowSize + col) == 40 || (row * boardRowSize + col) == 41
                        || (row * boardRowSize + col) == 48 || (row * boardRowSize + col) == 49 || (row * boardRowSize + col) == 50)) {
                    if ((row * boardRowSize + col) == 30) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 31) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 32) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 39) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 40) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 41) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 48) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 49) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 50) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    System.out.println("PLEASE CHOOSE A SQUARE THAT IS AVAILABLE AND WITHIN THE BLOCK");
                    UTTTGame.redoMove();
                }
            }
            case 5 -> {
                if (UTTTGame.implementT5 == 1) {
                    UTTTGame.lockBlock();
                }
                //tie
                if (UTTTGame.implementT5 != 1 && (!boxes[33].isAvailable() && !boxes[34].isAvailable() && !boxes[35].isAvailable()
                        && !boxes[42].isAvailable() && !boxes[43].isAvailable() && !boxes[44].isAvailable()
                        && !boxes[51].isAvailable() && !boxes[52].isAvailable() && !boxes[53].isAvailable())) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 33 || (row * boardRowSize + col) == 34 || (row * boardRowSize + col) == 35
                        || (row * boardRowSize + col) == 42 || (row * boardRowSize + col) == 43 || (row * boardRowSize + col) == 44
                        || (row * boardRowSize + col) == 51 || (row * boardRowSize + col) == 52 || (row * boardRowSize + col) == 53)) {
                    if ((row * boardRowSize + col) == 33) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 34) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 35) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 42) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 43) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 44) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 51) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 52) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 53) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    System.out.println("PLEASE CHOOSE A SQUARE THAT IS AVAILABLE AND WITHIN THE BLOCK");
                    UTTTGame.redoMove();
                }
            }
            case 6 -> {
                if (UTTTGame.implementT6 == 1) {
                    UTTTGame.lockBlock();
                }
                //tie
                if (UTTTGame.implementT6 != 1 && (!boxes[54].isAvailable() && !boxes[55].isAvailable() && !boxes[56].isAvailable()
                        && !boxes[63].isAvailable() && !boxes[64].isAvailable() && !boxes[65].isAvailable()
                        && !boxes[72].isAvailable() && !boxes[73].isAvailable() && !boxes[74].isAvailable())) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 54 || (row * boardRowSize + col) == 55 || (row * boardRowSize + col) == 56
                        || (row * boardRowSize + col) == 63 || (row * boardRowSize + col) == 64 || (row * boardRowSize + col) == 65
                        || (row * boardRowSize + col) == 72 || (row * boardRowSize + col) == 73 || (row * boardRowSize + col) == 74)) {
                    if ((row * boardRowSize + col) == 54) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 55) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 56) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 63) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 64) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 65) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 72) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 73) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 74) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    System.out.println("PLEASE CHOOSE A SQUARE THAT IS AVAILABLE AND WITHIN THE BLOCK");
                    UTTTGame.redoMove();
                }
            }
            case 7 -> {
                if (UTTTGame.implementT7 == 1) {
                    UTTTGame.lockBlock();
                }
                //tie
                if (UTTTGame.implementT7 != 1 && (!boxes[57].isAvailable() && !boxes[58].isAvailable() && !boxes[59].isAvailable()
                        && !boxes[66].isAvailable() && !boxes[67].isAvailable() && !boxes[68].isAvailable()
                        && !boxes[75].isAvailable() && !boxes[76].isAvailable() && !boxes[77].isAvailable())) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 57 || (row * boardRowSize + col) == 58 || (row * boardRowSize + col) == 59
                        || (row * boardRowSize + col) == 66 || (row * boardRowSize + col) == 67 || (row * boardRowSize + col) == 68
                        || (row * boardRowSize + col) == 75 || (row * boardRowSize + col) == 76 || (row * boardRowSize + col) == 77)) {
                    if ((row * boardRowSize + col) == 57) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 58) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 59) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 66) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 67) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 68) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 75) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 76) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 77) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    System.out.println("PLEASE CHOOSE A SQUARE THAT IS AVAILABLE AND WITHIN THE BLOCK");
                    UTTTGame.redoMove();
                }
            }
            case 8 -> {
                if (UTTTGame.implementT8 == 1) {
                    UTTTGame.lockBlock();
                }
                //tie
                if (UTTTGame.implementT8 != 1 && (!boxes[60].isAvailable() && !boxes[61].isAvailable() && !boxes[62].isAvailable()
                        && !boxes[69].isAvailable() && !boxes[70].isAvailable() && !boxes[71].isAvailable()
                        && !boxes[78].isAvailable() && !boxes[79].isAvailable() && !boxes[80].isAvailable())) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 60 || (row * boardRowSize + col) == 61 || (row * boardRowSize + col) == 62
                        || (row * boardRowSize + col) == 69 || (row * boardRowSize + col) == 70 || (row * boardRowSize + col) == 71
                        || (row * boardRowSize + col) == 78 || (row * boardRowSize + col) == 79 || (row * boardRowSize + col) == 80)) {
                    if ((row * boardRowSize + col) == 60) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 61) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 62) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 69) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 70) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 71) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 78) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 79) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 80) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }
                } else {
                    System.out.println("PLEASE CHOOSE A SQUARE THAT IS AVAILABLE AND WITHIN THE BLOCK");
                    UTTTGame.redoMove();
                }
            }
        }
    }
    //AI makes the move block isnt taken over and if its available, also asks the next players block
    void AImakeMove(String mark, int row, int col) {
        switch (UTTTGame.block) {
            case 0 -> {
                if (UTTTGame.implementT0 == 1) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 0 || (row * boardRowSize + col) == 1 || (row * boardRowSize + col) == 2
                        || (row * boardRowSize + col) == 9 || (row * boardRowSize + col) == 10 || (row * boardRowSize + col) == 11
                        || (row * boardRowSize + col) == 18 || (row * boardRowSize + col) == 19 || (row * boardRowSize + col) == 20)) {
                    if ((row * boardRowSize + col) == 0) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 1) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 2) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 9) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 10) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 11) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 18) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 19) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 20) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    UTTTGame.redoMove();
                }

            }
            case 1 -> {
                if (UTTTGame.implementT1 == 1) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 3 || (row * boardRowSize + col) == 4 || (row * boardRowSize + col) == 5
                        || (row * boardRowSize + col) == 12 || (row * boardRowSize + col) == 13 || (row * boardRowSize + col) == 14
                        || (row * boardRowSize + col) == 21 || (row * boardRowSize + col) == 22 || (row * boardRowSize + col) == 23)) {
                    if ((row * boardRowSize + col) == 3) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 4) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 5) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 9) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 12) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 13) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 21) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 22) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 23) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    UTTTGame.redoMove();
                }
            }

            case 2 -> {
                if (UTTTGame.implementT2 == 1) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 6 || (row * boardRowSize + col) == 7 || (row * boardRowSize + col) == 8
                        || (row * boardRowSize + col) == 15 || (row * boardRowSize + col) == 16 || (row * boardRowSize + col) == 17
                        || (row * boardRowSize + col) == 24 || (row * boardRowSize + col) == 25 || (row * boardRowSize + col) == 26)) {
                    if ((row * boardRowSize + col) == 6) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 7) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 8) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 15) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 16) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 17) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 24) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 25) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 26) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    UTTTGame.redoMove();
                }
            }
            case 3 -> {

                if (UTTTGame.implementT3 == 1) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 27 || (row * boardRowSize + col) == 28 || (row * boardRowSize + col) == 29
                        || (row * boardRowSize + col) == 36 || (row * boardRowSize + col) == 37 || (row * boardRowSize + col) == 38
                        || (row * boardRowSize + col) == 45 || (row * boardRowSize + col) == 46 || (row * boardRowSize + col) == 47)) {
                    if ((row * boardRowSize + col) == 27) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 28) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 29) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 36) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 37) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 38) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 45) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 46) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 47) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    UTTTGame.redoMove();
                }
            }
            case 4 -> {
                if (UTTTGame.implementT4 == 1) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 30 || (row * boardRowSize + col) == 31 || (row * boardRowSize + col) == 32
                        || (row * boardRowSize + col) == 39 || (row * boardRowSize + col) == 40 || (row * boardRowSize + col) == 41
                        || (row * boardRowSize + col) == 48 || (row * boardRowSize + col) == 49 || (row * boardRowSize + col) == 50)) {
                    if ((row * boardRowSize + col) == 30) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 31) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 32) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 39) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 40) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 41) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 48) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 49) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 50) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    UTTTGame.redoMove();
                }
            }
            case 5 -> {
                if (UTTTGame.implementT5 == 1) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 33 || (row * boardRowSize + col) == 34 || (row * boardRowSize + col) == 35
                        || (row * boardRowSize + col) == 42 || (row * boardRowSize + col) == 43 || (row * boardRowSize + col) == 44
                        || (row * boardRowSize + col) == 51 || (row * boardRowSize + col) == 52 || (row * boardRowSize + col) == 53)) {
                    if ((row * boardRowSize + col) == 33) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 34) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 35) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 42) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 43) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 44) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 51) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 52) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 53) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    UTTTGame.redoMove();
                }
            }
            case 6 -> {
                if (UTTTGame.implementT6 == 1) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 54 || (row * boardRowSize + col) == 55 || (row * boardRowSize + col) == 56
                        || (row * boardRowSize + col) == 63 || (row * boardRowSize + col) == 64 || (row * boardRowSize + col) == 65
                        || (row * boardRowSize + col) == 72 || (row * boardRowSize + col) == 73 || (row * boardRowSize + col) == 74)) {
                    if ((row * boardRowSize + col) == 54) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 55) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 56) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 63) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 64) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 65) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 72) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 73) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 74) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    UTTTGame.redoMove();
                }
            }
            case 7 -> {
                if (UTTTGame.implementT7 == 1) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 57 || (row * boardRowSize + col) == 58 || (row * boardRowSize + col) == 59
                        || (row * boardRowSize + col) == 66 || (row * boardRowSize + col) == 67 || (row * boardRowSize + col) == 68
                        || (row * boardRowSize + col) == 75 || (row * boardRowSize + col) == 76 || (row * boardRowSize + col) == 77)) {
                    if ((row * boardRowSize + col) == 57) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 58) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 59) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 66) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 67) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 68) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 75) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 76) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 77) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }

                } else {
                    UTTTGame.redoMove();
                }
            }
            case 8 -> {
                if (UTTTGame.implementT8 == 1) {
                    UTTTGame.lockBlock();
                } else if (boxes[row * boardRowSize + col].isAvailable() && ((row * boardRowSize + col) == 60 || (row * boardRowSize + col) == 61 || (row * boardRowSize + col) == 62
                        || (row * boardRowSize + col) == 69 || (row * boardRowSize + col) == 70 || (row * boardRowSize + col) == 71
                        || (row * boardRowSize + col) == 78 || (row * boardRowSize + col) == 79 || (row * boardRowSize + col) == 80)) {
                    if ((row * boardRowSize + col) == 60) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 0;
                    }
                    if ((row * boardRowSize + col) == 61) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 1;
                    }
                    if ((row * boardRowSize + col) == 62) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 2;
                    }
                    if ((row * boardRowSize + col) == 69) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 3;
                    }
                    if ((row * boardRowSize + col) == 70) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 4;
                    }
                    if ((row * boardRowSize + col) == 71) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 5;
                    }
                    if ((row * boardRowSize + col) == 78) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 6;
                    }
                    if ((row * boardRowSize + col) == 79) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 7;
                    }
                    if ((row * boardRowSize + col) == 80) {
                        boxes[row * boardRowSize + col].setPlaceHolder(mark);
                        copy[row * boardRowSize + col] = mark;
                        UTTTGame.block = 8;
                    }
                } else {
                    UTTTGame.redoMove();
                }
            }
        }
    }

    //finds Subboard winner by checking the copy of the object array and comparing it to the string "X" or "O"
    boolean ifBlock0Winner() {
        //checks for X win
        if (copy[0 * boardRowSize + 0].equals("X") && copy[0 * boardRowSize + 1].equals("X") && copy[0 * boardRowSize + 2].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[1 * boardRowSize + 0].equals("X") && copy[1 * boardRowSize + 1].equals("X") && copy[1 * boardRowSize + 2].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[2 * boardRowSize + 0].equals("X") && copy[2 * boardRowSize + 1].equals("X") && copy[2 * boardRowSize + 2].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 0].equals("X") && copy[1 * boardRowSize + 0].equals("X") && copy[2 * boardRowSize + 0].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 1].equals("X") && copy[1 * boardRowSize + 1].equals("X") && copy[2 * boardRowSize + 1].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 2].equals("X") && copy[1 * boardRowSize + 2].equals("X") && copy[2 * boardRowSize + 2].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 0].equals("X") && copy[1 * boardRowSize + 1].equals("X") && copy[2 * boardRowSize + 2].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 2].equals("X") && copy[1 * boardRowSize + 1].equals("X") && copy[2 * boardRowSize + 0].equals("X")) {
            winner = "X";

            return true;
        }
        //checks for O win
        if (copy[0 * boardRowSize + 0].equals("O") && copy[0 * boardRowSize + 1].equals("O") && copy[0 * boardRowSize + 2].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[1 * boardRowSize + 0].equals("O") && copy[1 * boardRowSize + 1].equals("O") && copy[1 * boardRowSize + 2].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[2 * boardRowSize + 0].equals("O") && copy[2 * boardRowSize + 1].equals("O") && copy[2 * boardRowSize + 2].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 0].equals("O") && copy[1 * boardRowSize + 0].equals("O") && copy[2 * boardRowSize + 0].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 1].equals("O") && copy[1 * boardRowSize + 1].equals("O") && copy[2 * boardRowSize + 1].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 2].equals("O") && copy[1 * boardRowSize + 2].equals("O") && copy[2 * boardRowSize + 2].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 0].equals("O") && copy[1 * boardRowSize + 1].equals("O") && copy[2 * boardRowSize + 2].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 2].equals("O") && copy[1 * boardRowSize + 1].equals("O") && copy[2 * boardRowSize + 0].equals("O")) {
            winner = "O";

            return true;
        } else 
        {
            return false;
        }

    }
    //places winner all over the block
    static void block0TakeOver(String winner) {
        for (int i = 0; i < (2 * boardRowSize + 3); i++) {
            boxes[0 * boardRowSize + 0].setWinnerPlaceHolder(winner);
            boxes[0 * boardRowSize + 1].setWinnerPlaceHolder(winner);
            boxes[0 * boardRowSize + 2].setWinnerPlaceHolder(winner);
            boxes[1 * boardRowSize + 0].setWinnerPlaceHolder(winner);
            boxes[1 * boardRowSize + 1].setWinnerPlaceHolder(winner);
            boxes[1 * boardRowSize + 2].setWinnerPlaceHolder(winner);
            boxes[2 * boardRowSize + 0].setWinnerPlaceHolder(winner);
            boxes[2 * boardRowSize + 1].setWinnerPlaceHolder(winner);
            boxes[2 * boardRowSize + 2].setWinnerPlaceHolder(winner);
            copy[0 * boardRowSize + 0] = winner;
            copy[0 * boardRowSize + 1] = winner;
            copy[0 * boardRowSize + 2] = winner;
            copy[1 * boardRowSize + 0] = winner;
            copy[1 * boardRowSize + 1] = winner;
            copy[1 * boardRowSize + 2] = winner;
            copy[2 * boardRowSize + 0] = winner;
            copy[2 * boardRowSize + 1] = winner;
            copy[2 * boardRowSize + 2] = winner;
        }
        print();
    }
    //finds Subboard winner by checking the copy of the object array and comparing it to the string "X" or "O"
    boolean ifBlock1Winner() {
        //checks for X win
        if (copy[0 * boardRowSize + 3].equals("X") && copy[0 * boardRowSize + 4].equals("X") && copy[0 * boardRowSize + 5].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[1 * boardRowSize + 3].equals("X") && copy[1 * boardRowSize + 4].equals("X") && copy[1 * boardRowSize + 5].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[2 * boardRowSize + 3].equals("X") && copy[2 * boardRowSize + 4].equals("X") && copy[2 * boardRowSize + 5].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 3].equals("X") && copy[1 * boardRowSize + 3].equals("X") && copy[2 * boardRowSize + 3].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 4].equals("X") && copy[1 * boardRowSize + 4].equals("X") && copy[2 * boardRowSize + 4].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 5].equals("X") && copy[1 * boardRowSize + 5].equals("X") && copy[2 * boardRowSize + 5].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 3].equals("X") && copy[1 * boardRowSize + 4].equals("X") && copy[2 * boardRowSize + 5].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 5].equals("X") && copy[1 * boardRowSize + 4].equals("X") && copy[2 * boardRowSize + 3].equals("X")) {
            winner = "X";

            return true;
        }
        //checks for O win
        if (copy[0 * boardRowSize + 3].equals("O") && copy[0 * boardRowSize + 4].equals("O") && copy[0 * boardRowSize + 5].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[1 * boardRowSize + 3].equals("O") && copy[1 * boardRowSize + 4].equals("O") && copy[1 * boardRowSize + 5].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[2 * boardRowSize + 3].equals("O") && copy[2 * boardRowSize + 4].equals("O") && copy[2 * boardRowSize + 5].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 3].equals("O") && copy[1 * boardRowSize + 3].equals("O") && copy[2 * boardRowSize + 3].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 4].equals("O") && copy[1 * boardRowSize + 4].equals("O") && copy[2 * boardRowSize + 4].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 5].equals("O") && copy[1 * boardRowSize + 5].equals("O") && copy[2 * boardRowSize + 5].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 3].equals("O") && copy[1 * boardRowSize + 4].equals("O") && copy[2 * boardRowSize + 5].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 5].equals("O") && copy[1 * boardRowSize + 4].equals("O") && copy[2 * boardRowSize + 3].equals("O")) {
            winner = "O";

            return true;
        } else 
        {
            return false;
        }

    }

    static void block1TakeOver(String winner) {
        for (int i = 0; i < (2 * boardRowSize + 6); i++) {
            boxes[0 * boardRowSize + 3].setWinnerPlaceHolder(winner);
            boxes[0 * boardRowSize + 4].setWinnerPlaceHolder(winner);
            boxes[0 * boardRowSize + 5].setWinnerPlaceHolder(winner);
            boxes[1 * boardRowSize + 3].setWinnerPlaceHolder(winner);
            boxes[1 * boardRowSize + 4].setWinnerPlaceHolder(winner);
            boxes[1 * boardRowSize + 5].setWinnerPlaceHolder(winner);
            boxes[2 * boardRowSize + 3].setWinnerPlaceHolder(winner);
            boxes[2 * boardRowSize + 4].setWinnerPlaceHolder(winner);
            boxes[2 * boardRowSize + 5].setWinnerPlaceHolder(winner);
            copy[0 * boardRowSize + 3] = winner;
            copy[0 * boardRowSize + 4] = winner;
            copy[0 * boardRowSize + 5] = winner;
            copy[1 * boardRowSize + 3] = winner;
            copy[1 * boardRowSize + 4] = winner;
            copy[1 * boardRowSize + 5] = winner;
            copy[2 * boardRowSize + 3] = winner;
            copy[2 * boardRowSize + 4] = winner;
            copy[2 * boardRowSize + 5] = winner;
        }
        print();
    }
     //finds Subboard winner by checking the copy of the object array and comparing it to the string "X" or "O"
    boolean ifBlock2Winner() {
        //checks for X win
        if (copy[0 * boardRowSize + 6].equals("X") && copy[0 * boardRowSize + 7].equals("X") && copy[0 * boardRowSize + 8].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[1 * boardRowSize + 6].equals("X") && copy[1 * boardRowSize + 7].equals("X") && copy[1 * boardRowSize + 8].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[2 * boardRowSize + 6].equals("X") && copy[2 * boardRowSize + 7].equals("X") && copy[2 * boardRowSize + 8].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 6].equals("X") && copy[1 * boardRowSize + 6].equals("X") && copy[2 * boardRowSize + 6].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 7].equals("X") && copy[1 * boardRowSize + 7].equals("X") && copy[2 * boardRowSize + 7].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 8].equals("X") && copy[1 * boardRowSize + 8].equals("X") && copy[2 * boardRowSize + 8].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 6].equals("X") && copy[1 * boardRowSize + 7].equals("X") && copy[2 * boardRowSize + 8].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 8].equals("X") && copy[1 * boardRowSize + 7].equals("X") && copy[2 * boardRowSize + 6].equals("X")) {
            winner = "X";

            return true;
        }
        //checks for O win
        if (copy[0 * boardRowSize + 6].equals("O") && copy[0 * boardRowSize + 7].equals("O") && copy[0 * boardRowSize + 8].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[1 * boardRowSize + 6].equals("O") && copy[1 * boardRowSize + 7].equals("O") && copy[1 * boardRowSize + 8].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[2 * boardRowSize + 6].equals("O") && copy[2 * boardRowSize + 7].equals("O") && copy[2 * boardRowSize + 8].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 6].equals("O") && copy[1 * boardRowSize + 6].equals("O") && copy[2 * boardRowSize + 6].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 7].equals("O") && copy[1 * boardRowSize + 7].equals("O") && copy[2 * boardRowSize + 7].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 8].equals("O") && copy[1 * boardRowSize + 8].equals("O") && copy[2 * boardRowSize + 8].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 6].equals("O") && copy[1 * boardRowSize + 7].equals("O") && copy[2 * boardRowSize + 8].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 8].equals("O") && copy[1 * boardRowSize + 7].equals("O") && copy[2 * boardRowSize + 6].equals("O")) {
            winner = "O";

            return true;
        } else
        {
            return false;
        }

    }

   static void block2TakeOver(String winner) {
        for (int i = 0; i < (2 * boardRowSize + 9); i++) {
            boxes[0 * boardRowSize + 6].setWinnerPlaceHolder(winner);
            boxes[0 * boardRowSize + 7].setWinnerPlaceHolder(winner);
            boxes[0 * boardRowSize + 8].setWinnerPlaceHolder(winner);
            boxes[1 * boardRowSize + 6].setWinnerPlaceHolder(winner);
            boxes[1 * boardRowSize + 7].setWinnerPlaceHolder(winner);
            boxes[1 * boardRowSize + 8].setWinnerPlaceHolder(winner);
            boxes[2 * boardRowSize + 6].setWinnerPlaceHolder(winner);
            boxes[2 * boardRowSize + 7].setWinnerPlaceHolder(winner);
            boxes[2 * boardRowSize + 8].setWinnerPlaceHolder(winner);
            copy[0 * boardRowSize + 6] = winner;
            copy[0 * boardRowSize + 7] = winner;
            copy[0 * boardRowSize + 8] = winner;
            copy[1 * boardRowSize + 6] = winner;
            copy[1 * boardRowSize + 7] = winner;
            copy[1 * boardRowSize + 8] = winner;
            copy[2 * boardRowSize + 6] = winner;
            copy[2 * boardRowSize + 7] = winner;
            copy[2 * boardRowSize + 8] = winner;
        }
        print();
    }
    //finds Subboard winner by checking the copy of the object array and comparing it to the string "X" or "O"
    boolean ifBlock3Winner() {
        //checks for X win
        if (copy[3 * boardRowSize + 0].equals("X") && copy[3 * boardRowSize + 1].equals("X") && copy[3 * boardRowSize + 2].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[4 * boardRowSize + 0].equals("X") && copy[4 * boardRowSize + 1].equals("X") && copy[4 * boardRowSize + 2].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[5 * boardRowSize + 0].equals("X") && copy[5 * boardRowSize + 1].equals("X") && copy[5 * boardRowSize + 2].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[3 * boardRowSize + 0].equals("X") && copy[4 * boardRowSize + 0].equals("X") && copy[5 * boardRowSize + 0].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[3 * boardRowSize + 1].equals("X") && copy[4 * boardRowSize + 1].equals("X") && copy[5 * boardRowSize + 1].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[3 * boardRowSize + 2].equals("X") && copy[4 * boardRowSize + 2].equals("X") && copy[5 * boardRowSize + 2].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[3 * boardRowSize + 0].equals("X") && copy[4 * boardRowSize + 1].equals("X") && copy[5 * boardRowSize + 2].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[3 * boardRowSize + 2].equals("X") && copy[4 * boardRowSize + 1].equals("X") && copy[5 * boardRowSize + 0].equals("X")) {
            winner = "X";

            return true;
        }
        //checks for O win
        if (copy[3 * boardRowSize + 0].equals("O") && copy[3 * boardRowSize + 1].equals("O") && copy[3 * boardRowSize + 2].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[4 * boardRowSize + 0].equals("O") && copy[4 * boardRowSize + 1].equals("O") && copy[4 * boardRowSize + 2].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[5 * boardRowSize + 0].equals("O") && copy[5 * boardRowSize + 1].equals("O") && copy[5 * boardRowSize + 2].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[3 * boardRowSize + 0].equals("O") && copy[4 * boardRowSize + 0].equals("O") && copy[5 * boardRowSize + 0].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[3 * boardRowSize + 1].equals("O") && copy[4 * boardRowSize + 1].equals("O") && copy[5 * boardRowSize + 1].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[3 * boardRowSize + 2].equals("O") && copy[4 * boardRowSize + 2].equals("O") && copy[5 * boardRowSize + 2].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[3 * boardRowSize + 0].equals("O") && copy[4 * boardRowSize + 1].equals("O") && copy[5 * boardRowSize + 2].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[3 * boardRowSize + 2].equals("O") && copy[4 * boardRowSize + 1].equals("O") && copy[5 * boardRowSize + 0].equals("O")) {
            winner = "O";

            return true;
        } else 
        {
            return false;
        }

    }
    
    static void block3TakeOver(String winner) {
        for (int i = 0; i < (5 * boardRowSize + 3); i++) {
            boxes[3 * boardRowSize + 0].setWinnerPlaceHolder(winner);
            boxes[3 * boardRowSize + 1].setWinnerPlaceHolder(winner);
            boxes[3 * boardRowSize + 2].setWinnerPlaceHolder(winner);
            boxes[4 * boardRowSize + 0].setWinnerPlaceHolder(winner);
            boxes[4 * boardRowSize + 1].setWinnerPlaceHolder(winner);
            boxes[4 * boardRowSize + 2].setWinnerPlaceHolder(winner);
            boxes[5 * boardRowSize + 0].setWinnerPlaceHolder(winner);
            boxes[5 * boardRowSize + 1].setWinnerPlaceHolder(winner);
            boxes[5 * boardRowSize + 2].setWinnerPlaceHolder(winner);
            copy[3 * boardRowSize + 0] = winner;
            copy[3 * boardRowSize + 1] = winner;
            copy[3 * boardRowSize + 2] = winner;
            copy[4 * boardRowSize + 0] = winner;
            copy[4 * boardRowSize + 1] = winner;
            copy[4 * boardRowSize + 2] = winner;
            copy[5 * boardRowSize + 0] = winner;
            copy[5 * boardRowSize + 1] = winner;
            copy[5 * boardRowSize + 2] = winner;
        }
        print();
    }
     //finds Subboard winner by checking the copy of the object array and comparing it to the string "X" or "O"
    boolean ifBlock4Winner() {
        //checks for X win
        if (copy[3 * boardRowSize + 3].equals("X") && copy[3 * boardRowSize + 4].equals("X") && copy[3 * boardRowSize + 5].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[4 * boardRowSize + 3].equals("X") && copy[4 * boardRowSize + 4].equals("X") && copy[4 * boardRowSize + 5].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[5 * boardRowSize + 3].equals("X") && copy[5 * boardRowSize + 4].equals("X") && copy[5 * boardRowSize + 5].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[3 * boardRowSize + 3].equals("X") && copy[4 * boardRowSize + 3].equals("X") && copy[5 * boardRowSize + 3].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[3 * boardRowSize + 4].equals("X") && copy[4 * boardRowSize + 4].equals("X") && copy[5 * boardRowSize + 4].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[3 * boardRowSize + 5].equals("X") && copy[4 * boardRowSize + 5].equals("X") && copy[5 * boardRowSize + 5].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[3 * boardRowSize + 3].equals("X") && copy[4 * boardRowSize + 4].equals("X") && copy[5 * boardRowSize + 5].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[3 * boardRowSize + 5].equals("X") && copy[4 * boardRowSize + 4].equals("X") && copy[5 * boardRowSize + 3].equals("X")) {
            winner = "X";

            return true;
        }
        //checks for O win
        if (copy[3 * boardRowSize + 3].equals("O") && copy[3 * boardRowSize + 4].equals("O") && copy[3 * boardRowSize + 5].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[4 * boardRowSize + 3].equals("O") && copy[4 * boardRowSize + 4].equals("O") && copy[4 * boardRowSize + 5].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[5 * boardRowSize + 3].equals("O") && copy[5 * boardRowSize + 4].equals("O") && copy[5 * boardRowSize + 5].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[3 * boardRowSize + 3].equals("O") && copy[4 * boardRowSize + 3].equals("O") && copy[5 * boardRowSize + 3].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[3 * boardRowSize + 4].equals("O") && copy[4 * boardRowSize + 4].equals("O") && copy[5 * boardRowSize + 4].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[3 * boardRowSize + 5].equals("O") && copy[4 * boardRowSize + 5].equals("O") && copy[5 * boardRowSize + 5].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[3 * boardRowSize + 3].equals("O") && copy[4 * boardRowSize + 4].equals("O") && copy[5 * boardRowSize + 5].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[3 * boardRowSize + 5].equals("O") && copy[4 * boardRowSize + 4].equals("O") && copy[5 * boardRowSize + 3].equals("O")) {
            winner = "O";

            return true;
        } else 
        {
            return false;
        }

    }
    
    static void block4TakeOver(String winner) {
        for (int i = 0; i < (5 * boardRowSize + 6); i++) {
            boxes[3 * boardRowSize + 3].setWinnerPlaceHolder(winner);
            boxes[3 * boardRowSize + 4].setWinnerPlaceHolder(winner);
            boxes[3 * boardRowSize + 5].setWinnerPlaceHolder(winner);
            boxes[4 * boardRowSize + 3].setWinnerPlaceHolder(winner);
            boxes[4 * boardRowSize + 4].setWinnerPlaceHolder(winner);
            boxes[4 * boardRowSize + 5].setWinnerPlaceHolder(winner);
            boxes[5 * boardRowSize + 3].setWinnerPlaceHolder(winner);
            boxes[5 * boardRowSize + 4].setWinnerPlaceHolder(winner);
            boxes[5 * boardRowSize + 5].setWinnerPlaceHolder(winner);
            copy[3 * boardRowSize + 3] = winner;
            copy[3 * boardRowSize + 4] = winner;
            copy[3 * boardRowSize + 5] = winner;
            copy[4 * boardRowSize + 3] = winner;
            copy[4 * boardRowSize + 4] = winner;
            copy[4 * boardRowSize + 5] = winner;
            copy[5 * boardRowSize + 3] = winner;
            copy[5 * boardRowSize + 4] = winner;
            copy[5 * boardRowSize + 5] = winner;
        }
        print();
    }
     //finds Subboard winner by checking the copy of the object array and comparing it to the string "X" or "O"
    boolean ifBlock5Winner() {
        //checks for X win
        if (copy[3 * boardRowSize + 6].equals("X") && copy[3 * boardRowSize + 7].equals("X") && copy[3 * boardRowSize + 8].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[4 * boardRowSize + 6].equals("X") && copy[4 * boardRowSize + 7].equals("X") && copy[4 * boardRowSize + 8].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[5 * boardRowSize + 6].equals("X") && copy[5 * boardRowSize + 7].equals("X") && copy[5 * boardRowSize + 8].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[3 * boardRowSize + 6].equals("X") && copy[4 * boardRowSize + 6].equals("X") && copy[5 * boardRowSize + 6].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[3 * boardRowSize + 7].equals("X") && copy[4 * boardRowSize + 7].equals("X") && copy[5 * boardRowSize + 7].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[3 * boardRowSize + 8].equals("X") && copy[4 * boardRowSize + 8].equals("X") && copy[5 * boardRowSize + 8].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[3 * boardRowSize + 6].equals("X") && copy[4 * boardRowSize + 7].equals("X") && copy[5 * boardRowSize + 8].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[3 * boardRowSize + 8].equals("X") && copy[4 * boardRowSize + 7].equals("X") && copy[5 * boardRowSize + 6].equals("X")) {
            winner = "X";

            return true;
        }
        //checks for O win
        if (copy[3 * boardRowSize + 6].equals("O") && copy[3 * boardRowSize + 7].equals("O") && copy[3 * boardRowSize + 8].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[4 * boardRowSize + 6].equals("O") && copy[4 * boardRowSize + 7].equals("O") && copy[4 * boardRowSize + 8].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[5 * boardRowSize + 6].equals("O") && copy[5 * boardRowSize + 7].equals("O") && copy[5 * boardRowSize + 8].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[3 * boardRowSize + 6].equals("O") && copy[4 * boardRowSize + 6].equals("O") && copy[5 * boardRowSize + 6].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[3 * boardRowSize + 7].equals("O") && copy[4 * boardRowSize + 7].equals("O") && copy[5 * boardRowSize + 7].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[3 * boardRowSize + 8].equals("O") && copy[4 * boardRowSize + 8].equals("O") && copy[5 * boardRowSize + 8].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[3 * boardRowSize + 6].equals("O") && copy[4 * boardRowSize + 7].equals("O") && copy[5 * boardRowSize + 8].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[3 * boardRowSize + 8].equals("O") && copy[4 * boardRowSize + 7].equals("O") && copy[5 * boardRowSize + 6].equals("O")) {
            winner = "O";

            return true;
        } else
        {
            return false;
        }

    }

    static void block5TakeOver(String winner) {
        for (int i = 0; i < (5 * boardRowSize + 9); i++) {
            boxes[3 * boardRowSize + 6].setWinnerPlaceHolder(winner);
            boxes[3 * boardRowSize + 7].setWinnerPlaceHolder(winner);
            boxes[3 * boardRowSize + 8].setWinnerPlaceHolder(winner);
            boxes[4 * boardRowSize + 6].setWinnerPlaceHolder(winner);
            boxes[4 * boardRowSize + 7].setWinnerPlaceHolder(winner);
            boxes[4 * boardRowSize + 8].setWinnerPlaceHolder(winner);
            boxes[5 * boardRowSize + 6].setWinnerPlaceHolder(winner);
            boxes[5 * boardRowSize + 7].setWinnerPlaceHolder(winner);
            boxes[5 * boardRowSize + 8].setWinnerPlaceHolder(winner);
            copy[3 * boardRowSize + 6] = winner;
            copy[3 * boardRowSize + 7] = winner;
            copy[3 * boardRowSize + 8] = winner;
            copy[4 * boardRowSize + 6] = winner;
            copy[4 * boardRowSize + 7] = winner;
            copy[4 * boardRowSize + 8] = winner;
            copy[5 * boardRowSize + 6] = winner;
            copy[5 * boardRowSize + 7] = winner;
            copy[5 * boardRowSize + 8] = winner;
        }
        print();
    }
     //finds Subboard winner by checking the copy of the object array and comparing it to the string "X" or "O"
    boolean ifBlock6Winner() {
        //checks for X win
        if (copy[6 * boardRowSize + 0].equals("X") && copy[6 * boardRowSize + 1].equals("X") && copy[6 * boardRowSize + 2].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[7 * boardRowSize + 0].equals("X") && copy[7 * boardRowSize + 1].equals("X") && copy[7 * boardRowSize + 2].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[8 * boardRowSize + 0].equals("X") && copy[8 * boardRowSize + 1].equals("X") && copy[8 * boardRowSize + 2].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[6 * boardRowSize + 0].equals("X") && copy[7 * boardRowSize + 0].equals("X") && copy[8 * boardRowSize + 0].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[6 * boardRowSize + 1].equals("X") && copy[7 * boardRowSize + 1].equals("X") && copy[8 * boardRowSize + 1].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[6 * boardRowSize + 2].equals("X") && copy[7 * boardRowSize + 2].equals("X") && copy[8 * boardRowSize + 2].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[6 * boardRowSize + 0].equals("X") && copy[7 * boardRowSize + 1].equals("X") && copy[8 * boardRowSize + 2].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[6 * boardRowSize + 2].equals("X") && copy[7 * boardRowSize + 1].equals("X") && copy[8 * boardRowSize + 0].equals("X")) {
            winner = "X";

            return true;
        }
        //checks for O win
        if (copy[6 * boardRowSize + 0].equals("O") && copy[6 * boardRowSize + 1].equals("O") && copy[6 * boardRowSize + 2].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[7 * boardRowSize + 0].equals("O") && copy[7 * boardRowSize + 1].equals("O") && copy[7 * boardRowSize + 2].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[8 * boardRowSize + 0].equals("O") && copy[8 * boardRowSize + 1].equals("O") && copy[8 * boardRowSize + 2].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[6 * boardRowSize + 0].equals("O") && copy[7 * boardRowSize + 0].equals("O") && copy[8 * boardRowSize + 0].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[6 * boardRowSize + 1].equals("O") && copy[7 * boardRowSize + 1].equals("O") && copy[8 * boardRowSize + 1].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[6 * boardRowSize + 2].equals("O") && copy[7 * boardRowSize + 2].equals("O") && copy[8 * boardRowSize + 2].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[6 * boardRowSize + 0].equals("O") && copy[7 * boardRowSize + 1].equals("O") && copy[8 * boardRowSize + 2].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[6 * boardRowSize + 2].equals("O") && copy[7 * boardRowSize + 1].equals("O") && copy[8 * boardRowSize + 0].equals("O")) {
            winner = "O";

            return true;
        } else 
        {
            return false;
        }

    }

    static void block6TakeOver(String winner) {
        for (int i = 0; i < (8 * boardRowSize + 3); i++) {
            boxes[6 * boardRowSize + 0].setWinnerPlaceHolder(winner);
            boxes[6 * boardRowSize + 1].setWinnerPlaceHolder(winner);
            boxes[6 * boardRowSize + 2].setWinnerPlaceHolder(winner);
            boxes[7 * boardRowSize + 0].setWinnerPlaceHolder(winner);
            boxes[7 * boardRowSize + 1].setWinnerPlaceHolder(winner);
            boxes[7 * boardRowSize + 2].setWinnerPlaceHolder(winner);
            boxes[8 * boardRowSize + 0].setWinnerPlaceHolder(winner);
            boxes[8 * boardRowSize + 1].setWinnerPlaceHolder(winner);
            boxes[8 * boardRowSize + 2].setWinnerPlaceHolder(winner);
            copy[6 * boardRowSize + 0] = winner;
            copy[6 * boardRowSize + 1] = winner;
            copy[6 * boardRowSize + 2] = winner;
            copy[7 * boardRowSize + 0] = winner;
            copy[7 * boardRowSize + 1] = winner;
            copy[7 * boardRowSize + 2] = winner;
            copy[8 * boardRowSize + 0] = winner;
            copy[8 * boardRowSize + 1] = winner;
            copy[8 * boardRowSize + 2] = winner;
        }
        print();
    }
     //finds Subboard winner by checking the copy of the object array and comparing it to the string "X" or "O"
    boolean ifBlock7Winner() {
        //checks for X win
        if (copy[6 * boardRowSize + 3].equals("X") && copy[6 * boardRowSize + 4].equals("X") && copy[6 * boardRowSize + 5].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[7 * boardRowSize + 3].equals("X") && copy[7 * boardRowSize + 4].equals("X") && copy[7 * boardRowSize + 5].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[8 * boardRowSize + 3].equals("X") && copy[8 * boardRowSize + 4].equals("X") && copy[8 * boardRowSize + 5].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[6 * boardRowSize + 3].equals("X") && copy[7 * boardRowSize + 3].equals("X") && copy[8 * boardRowSize + 3].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[6 * boardRowSize + 4].equals("X") && copy[7 * boardRowSize + 4].equals("X") && copy[8 * boardRowSize + 4].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[6 * boardRowSize + 5].equals("X") && copy[7 * boardRowSize + 5].equals("X") && copy[8 * boardRowSize + 5].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[6 * boardRowSize + 3].equals("X") && copy[7 * boardRowSize + 4].equals("X") && copy[8 * boardRowSize + 5].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[6 * boardRowSize + 5].equals("X") && copy[7 * boardRowSize + 4].equals("X") && copy[8 * boardRowSize + 3].equals("X")) {
            winner = "X";

            return true;
        }
        //checks for O win
        if (copy[6 * boardRowSize + 3].equals("O") && copy[6 * boardRowSize + 4].equals("O") && copy[6 * boardRowSize + 5].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[7 * boardRowSize + 3].equals("O") && copy[7 * boardRowSize + 4].equals("O") && copy[7 * boardRowSize + 5].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[8 * boardRowSize + 3].equals("O") && copy[8 * boardRowSize + 4].equals("O") && copy[8 * boardRowSize + 5].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[6 * boardRowSize + 3].equals("O") && copy[7 * boardRowSize + 3].equals("O") && copy[8 * boardRowSize + 3].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[6 * boardRowSize + 4].equals("O") && copy[7 * boardRowSize + 4].equals("O") && copy[8 * boardRowSize + 4].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[6 * boardRowSize + 5].equals("O") && copy[7 * boardRowSize + 5].equals("O") && copy[8 * boardRowSize + 5].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[6 * boardRowSize + 3].equals("O") && copy[7 * boardRowSize + 4].equals("O") && copy[8 * boardRowSize + 5].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[6 * boardRowSize + 5].equals("O") && copy[7 * boardRowSize + 4].equals("O") && copy[8 * boardRowSize + 3].equals("O")) {
            winner = "O";

            return true;
        } else 
        {
            return false;
        }

    }

    static void block7TakeOver(String winner) {
        for (int i = 0; i < (8 * boardRowSize + 6); i++) {
            boxes[6 * boardRowSize + 3].setWinnerPlaceHolder(winner);
            boxes[6 * boardRowSize + 4].setWinnerPlaceHolder(winner);
            boxes[6 * boardRowSize + 5].setWinnerPlaceHolder(winner);
            boxes[7 * boardRowSize + 3].setWinnerPlaceHolder(winner);
            boxes[7 * boardRowSize + 4].setWinnerPlaceHolder(winner);
            boxes[7 * boardRowSize + 5].setWinnerPlaceHolder(winner);
            boxes[8 * boardRowSize + 3].setWinnerPlaceHolder(winner);
            boxes[8 * boardRowSize + 4].setWinnerPlaceHolder(winner);
            boxes[8 * boardRowSize + 5].setWinnerPlaceHolder(winner);
            copy[6 * boardRowSize + 3] = winner;
            copy[6 * boardRowSize + 4] = winner;
            copy[6 * boardRowSize + 5] = winner;
            copy[7 * boardRowSize + 3] = winner;
            copy[7 * boardRowSize + 4] = winner;
            copy[7 * boardRowSize + 5] = winner;
            copy[8 * boardRowSize + 3] = winner;
            copy[8 * boardRowSize + 4] = winner;
            copy[8 * boardRowSize + 5] = winner;
        }
        print();
    }
     //finds Subboard winner by checking the copy of the object array and comparing it to the string "X" or "O"
    boolean ifBlock8Winner() {
        //checks for X win
        if (copy[6 * boardRowSize + 6].equals("X") && copy[6 * boardRowSize + 7].equals("X") && copy[6 * boardRowSize + 8].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[7 * boardRowSize + 6].equals("X") && copy[7 * boardRowSize + 7].equals("X") && copy[7 * boardRowSize + 8].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[8 * boardRowSize + 6].equals("X") && copy[8 * boardRowSize + 7].equals("X") && copy[8 * boardRowSize + 8].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[6 * boardRowSize + 6].equals("X") && copy[7 * boardRowSize + 6].equals("X") && copy[8 * boardRowSize + 6].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[6 * boardRowSize + 7].equals("X") && copy[7 * boardRowSize + 7].equals("X") && copy[8 * boardRowSize + 7].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[6 * boardRowSize + 8].equals("X") && copy[7 * boardRowSize + 8].equals("X") && copy[8 * boardRowSize + 8].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[6 * boardRowSize + 6].equals("X") && copy[7 * boardRowSize + 7].equals("X") && copy[8 * boardRowSize + 8].equals("X")) {
            winner = "X";

            return true;
        } else if (copy[6 * boardRowSize + 8].equals("X") && copy[7 * boardRowSize + 7].equals("X") && copy[8 * boardRowSize + 6].equals("X")) {
            winner = "X";

            return true;
        }
        //checks for O win
        if (copy[6 * boardRowSize + 6].equals("O") && copy[6 * boardRowSize + 7].equals("O") && copy[6 * boardRowSize + 8].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[7 * boardRowSize + 6].equals("O") && copy[7 * boardRowSize + 7].equals("O") && copy[7 * boardRowSize + 8].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[8 * boardRowSize + 6].equals("O") && copy[8 * boardRowSize + 7].equals("O") && copy[8 * boardRowSize + 8].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[6 * boardRowSize + 6].equals("O") && copy[7 * boardRowSize + 6].equals("O") && copy[8 * boardRowSize + 6].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[6 * boardRowSize + 7].equals("O") && copy[7 * boardRowSize + 7].equals("O") && copy[8 * boardRowSize + 7].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[6 * boardRowSize + 8].equals("O") && copy[7 * boardRowSize + 8].equals("O") && copy[8 * boardRowSize + 8].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[6 * boardRowSize + 6].equals("O") && copy[7 * boardRowSize + 7].equals("O") && copy[8 * boardRowSize + 8].equals("O")) {
            winner = "O";

            return true;
        } else if (copy[6 * boardRowSize + 8].equals("O") && copy[7 * boardRowSize + 7].equals("O") && copy[8 * boardRowSize + 6].equals("O")) {
            winner = "O";

            return true;
        } else 
        {
            return false;
        }

    }

    static void block8TakeOver(String winner) {
        for (int i = 0; i < (8 * boardRowSize + 9); i++) {
            boxes[6 * boardRowSize + 6].setWinnerPlaceHolder(winner);
            boxes[6 * boardRowSize + 7].setWinnerPlaceHolder(winner);
            boxes[6 * boardRowSize + 8].setWinnerPlaceHolder(winner);
            boxes[7 * boardRowSize + 6].setWinnerPlaceHolder(winner);
            boxes[7 * boardRowSize + 7].setWinnerPlaceHolder(winner);
            boxes[7 * boardRowSize + 8].setWinnerPlaceHolder(winner);
            boxes[8 * boardRowSize + 6].setWinnerPlaceHolder(winner);
            boxes[8 * boardRowSize + 7].setWinnerPlaceHolder(winner);
            boxes[8 * boardRowSize + 8].setWinnerPlaceHolder(winner);
            copy[6 * boardRowSize + 6] = winner;
            copy[6 * boardRowSize + 7] = winner;
            copy[6 * boardRowSize + 8] = winner;
            copy[7 * boardRowSize + 6] = winner;
            copy[7 * boardRowSize + 7] = winner;
            copy[7 * boardRowSize + 8] = winner;
            copy[8 * boardRowSize + 6] = winner;
            copy[8 * boardRowSize + 7] = winner;
            copy[8 * boardRowSize + 8] = winner;
        }
        print();
    }
    //finds the whole board winner
    public boolean gameWinner() {
        if (copy[1 * boardRowSize + 0].equals("X") && copy[1 * boardRowSize + 3].equals("X") && copy[1 * boardRowSize + 6].equals("X")
                && copy[1 * boardRowSize + 1].equals("X") && copy[1 * boardRowSize + 4].equals("X") && copy[1 * boardRowSize + 7].equals("X")
                && copy[1 * boardRowSize + 2].equals("X") && copy[1 * boardRowSize + 5].equals("X") && copy[1 * boardRowSize + 8].equals("X")) {
            gameWinner = "X";

            return true;
        } else if (copy[4 * boardRowSize + 0].equals("X") && copy[4 * boardRowSize + 3].equals("X") && copy[4 * boardRowSize + 6].equals("X")
                && copy[4 * boardRowSize + 1].equals("X") && copy[4 * boardRowSize + 4].equals("X") && copy[4 * boardRowSize + 7].equals("X")
                && copy[4 * boardRowSize + 2].equals("X") && copy[4 * boardRowSize + 5].equals("X") && copy[4 * boardRowSize + 8].equals("X")) {
            gameWinner = "X";

            return true;
        } else if (copy[7 * boardRowSize + 0].equals("X") && copy[7 * boardRowSize + 3].equals("X") && copy[7 * boardRowSize + 6].equals("X")
                && copy[7 * boardRowSize + 1].equals("X") && copy[7 * boardRowSize + 4].equals("X") && copy[7 * boardRowSize + 7].equals("X")
                && copy[7 * boardRowSize + 2].equals("X") && copy[7 * boardRowSize + 5].equals("X") && copy[7 * boardRowSize + 8].equals("X")) {
            gameWinner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 1].equals("X") && copy[3 * boardRowSize + 1].equals("X") && copy[6 * boardRowSize + 1].equals("X")
                && copy[1 * boardRowSize + 1].equals("X") && copy[4 * boardRowSize + 1].equals("X") && copy[7 * boardRowSize + 1].equals("X")
                && copy[2 * boardRowSize + 1].equals("X") && copy[5 * boardRowSize + 1].equals("X") && copy[8 * boardRowSize + 1].equals("X")) {
            gameWinner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 4].equals("X") && copy[3 * boardRowSize + 4].equals("X") && copy[6 * boardRowSize + 4].equals("X")
                && copy[1 * boardRowSize + 4].equals("X") && copy[4 * boardRowSize + 4].equals("X") && copy[7 * boardRowSize + 4].equals("X")
                && copy[2 * boardRowSize + 4].equals("X") && copy[5 * boardRowSize + 4].equals("X") && copy[8 * boardRowSize + 4].equals("X")) {
            gameWinner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 7].equals("X") && copy[3 * boardRowSize + 7].equals("X") && copy[6 * boardRowSize + 7].equals("X")
                && copy[1 * boardRowSize + 7].equals("X") && copy[4 * boardRowSize + 7].equals("X") && copy[7 * boardRowSize + 7].equals("X")
                && copy[2 * boardRowSize + 7].equals("X") && copy[5 * boardRowSize + 7].equals("X") && copy[8 * boardRowSize + 7].equals("X")) {
            gameWinner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 0].equals("X") && copy[3 * boardRowSize + 3].equals("X") && copy[6 * boardRowSize + 6].equals("X")
                && copy[1 * boardRowSize + 1].equals("X") && copy[4 * boardRowSize + 4].equals("X") && copy[7 * boardRowSize + 7].equals("X")
                && copy[2 * boardRowSize + 2].equals("X") && copy[5 * boardRowSize + 5].equals("X") && copy[8 * boardRowSize + 8].equals("X")) {
            gameWinner = "X";

            return true;
        } else if (copy[0 * boardRowSize + 8].equals("X") && copy[3 * boardRowSize + 5].equals("X") && copy[6 * boardRowSize + 2].equals("X")
                && copy[1 * boardRowSize + 7].equals("X") && copy[4 * boardRowSize + 4].equals("X") && copy[7 * boardRowSize + 1].equals("X")
                && copy[2 * boardRowSize + 6].equals("X") && copy[5 * boardRowSize + 3].equals("X") && copy[8 * boardRowSize + 0].equals("X")) {
            gameWinner = "X";

            return true;
        }
        //checks for O win
        if (copy[1 * boardRowSize + 0].equals("O") && copy[1 * boardRowSize + 3].equals("O") && copy[1 * boardRowSize + 6].equals("O")
                && copy[1 * boardRowSize + 1].equals("O") && copy[1 * boardRowSize + 4].equals("O") && copy[1 * boardRowSize + 7].equals("O")
                && copy[1 * boardRowSize + 2].equals("O") && copy[1 * boardRowSize + 5].equals("O") && copy[1 * boardRowSize + 8].equals("O")) {
            gameWinner = "O";

            return true;
        } else if (copy[4 * boardRowSize + 0].equals("O") && copy[4 * boardRowSize + 3].equals("O") && copy[4 * boardRowSize + 6].equals("O")
                && copy[4 * boardRowSize + 1].equals("O") && copy[4 * boardRowSize + 4].equals("O") && copy[4 * boardRowSize + 7].equals("O")
                && copy[4 * boardRowSize + 2].equals("O") && copy[4 * boardRowSize + 5].equals("O") && copy[4 * boardRowSize + 8].equals("O")) {
            gameWinner = "O";

            return true;
        } else if (copy[7 * boardRowSize + 0].equals("O") && copy[7 * boardRowSize + 3].equals("O") && copy[7 * boardRowSize + 6].equals("O")
                && copy[7 * boardRowSize + 1].equals("O") && copy[7 * boardRowSize + 4].equals("O") && copy[7 * boardRowSize + 7].equals("O")
                && copy[7 * boardRowSize + 2].equals("O") && copy[7 * boardRowSize + 5].equals("O") && copy[7 * boardRowSize + 8].equals("O")) {
            gameWinner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 1].equals("O") && copy[3 * boardRowSize + 1].equals("O") && copy[6 * boardRowSize + 1].equals("O")
                && copy[1 * boardRowSize + 1].equals("O") && copy[4 * boardRowSize + 1].equals("O") && copy[7 * boardRowSize + 1].equals("O")
                && copy[2 * boardRowSize + 1].equals("O") && copy[5 * boardRowSize + 1].equals("O") && copy[8 * boardRowSize + 1].equals("O")) {
            gameWinner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 4].equals("O") && copy[3 * boardRowSize + 4].equals("O") && copy[6 * boardRowSize + 4].equals("O")
                && copy[1 * boardRowSize + 4].equals("O") && copy[4 * boardRowSize + 4].equals("O") && copy[7 * boardRowSize + 4].equals("O")
                && copy[2 * boardRowSize + 4].equals("O") && copy[5 * boardRowSize + 4].equals("O") && copy[8 * boardRowSize + 4].equals("O")) {
            gameWinner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 7].equals("O") && copy[3 * boardRowSize + 7].equals("O") && copy[6 * boardRowSize + 7].equals("O")
                && copy[1 * boardRowSize + 7].equals("O") && copy[4 * boardRowSize + 7].equals("O") && copy[7 * boardRowSize + 7].equals("O")
                && copy[2 * boardRowSize + 7].equals("O") && copy[5 * boardRowSize + 7].equals("O") && copy[8 * boardRowSize + 7].equals("O")) {
            gameWinner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 0].equals("O") && copy[3 * boardRowSize + 3].equals("O") && copy[6 * boardRowSize + 6].equals("O")
                && copy[1 * boardRowSize + 1].equals("O") && copy[4 * boardRowSize + 4].equals("O") && copy[7 * boardRowSize + 7].equals("O")
                && copy[2 * boardRowSize + 2].equals("O") && copy[5 * boardRowSize + 5].equals("O") && copy[8 * boardRowSize + 8].equals("O")) {
            gameWinner = "O";

            return true;
        } else if (copy[0 * boardRowSize + 8].equals("O") && copy[3 * boardRowSize + 5].equals("O") && copy[6 * boardRowSize + 2].equals("O")
                && copy[1 * boardRowSize + 7].equals("O") && copy[4 * boardRowSize + 4].equals("O") && copy[7 * boardRowSize + 1].equals("O")
                && copy[2 * boardRowSize + 6].equals("O") && copy[5 * boardRowSize + 3].equals("O") && copy[8 * boardRowSize + 0].equals("O")) {
            gameWinner = "O";

            return true;
        } else {
            return false;
        }
    }
    //if board is full, then its a tie
    public boolean isFull() {
        for (Box b : boxes) {
            if (b.isAvailable()) {
                return false;
            }
        }
        return true;
    }
    
    public String getMark(int row, int col) {
        return boxes[row * boardRowSize + col].getPlaceHolder();
    }

}
