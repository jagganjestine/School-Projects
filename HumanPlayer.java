package UltimateTicTacToe;
//Jaggan Jestine JAJ180010 2336.003

//this class sets the human player with a mark and a player name
public class HumanPlayer {

    private String name;
    private String mark;

    public HumanPlayer(String name, String mark) {
        this.setName(name);
        this.setMark(mark);
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getMark() {
        return mark;
    }

    void setMark(String mark) {
        this.mark = mark;
    }

}
