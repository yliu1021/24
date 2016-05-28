package GameLogic.Board;

/**
 * Created by Haimo Zhang on 5/28/2016.
 */
public class Location {

    private int row;
    private int col;

    public Location(int row, int col){
        this.row = row;
        this.col = col;

    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }
}
