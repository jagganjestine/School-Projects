package UltimateTicTacToe;
//Jaggan Jestine JAJ180010 2336.003

//this class sets up the AI player, with a mark and a name, along with a random move generator
public class ComputerPlayer {

    private String name;
    private String mark;

    public ComputerPlayer(String name, String mark) {
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
    //random move generator
    public int randomNumber(int range) {
        return (int) (Math.random() * range);
    }
}
