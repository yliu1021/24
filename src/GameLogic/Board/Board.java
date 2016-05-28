package GameLogic.Board;

import GameLogic.Player;

/**
 * Created by Yuhan on 5/28/16.
 */
public class Board implements Occupant{

    Player player1 = new Player();
    Player player2 = new Player();
    Occupant[][] occupants;

    public Board(int size){
        occupants = new Occupant[size][size];

    }

    public void setOccupant(Occupant o,Location l,Player p){

    }

    public Segment[] evaluate(){

        return null;
    }

    public void clear(Segment[] s){

    }

    @Override
    public Location getLocation() {
        return null;
    }

    @Override
    public void setLocation(Location x) {

    }
}
