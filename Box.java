package UltimateTicTacToe;
//Jaggan Jestine JAJ180010 2336.003

//this box class is used to initilize an object array for the game board
public class Box {

    private int row;
    private int col;
    private final static String DASH = "-";
    private String placeHolder = Box.DASH;

    Box(int row, int col) {
        this.row = row;
        this.col = col;
    }

    String getPlaceHolder() {
        return placeHolder;
    }
    //sets the placeHolder on the board if the box is available
    boolean setPlaceHolder(String placeHolder) {
        if (isAvailable()) {
            this.placeHolder = placeHolder;
            return true;
        }
        return false;
    }
    // this is used in the takeover methods to place the winner mark all over the conquered block
    boolean setWinnerPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
        return true;
    }
    //checks if box has mark or not
    boolean isAvailable() {
        return this.placeHolder.equals(Box.DASH);
    }

    void print() {
        System.out.print(placeHolder + " ");
    }
}
