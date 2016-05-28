package GameLogic.Board;

import GameLogic.Board.Occupants.Occupant;
import GameLogic.Player;

/**
 * Created by Yuhan on 5/28/16.
 */
public class Board {

    Player player1 = new Player();
    Player player2 = new Player();
    Occupant[][] occupants;

    public Board(int size){
        occupants = new Occupant[size][size];

    }

    public void setOccupant(Occupant o,Location l,Player p){
        int row = l.getRow();
        int col = l.getCol();
        occupants[row][col] = o;
        Segment[] s = evaluate();
    }

    public Segment[] evaluate(){
        return null;
    }

    public void clear(Segment[] s){
        for (int i = 0;i < s.length; i++){
            Location start = s[i].getStart();
            Location end = s[i].getEnd();
            int row = start.getRow();
            int col = start.getCol();

            int dX = end.getRow() - start.getRow();
            int dY = end.getCol() - start.getCol();
            while(!start.equals(end)){
                occupants[row][col] = null;
                row+= dX;
                col += dY;
                start.setRow(row);
                start.setCol(col);
            }
        }

    }

}
