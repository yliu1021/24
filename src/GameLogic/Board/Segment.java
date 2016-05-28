package GameLogic.Board;

/**
 * Created by Haimo Zhang on 5/28/2016.
 */
public class Segment {

    private Location start;
    private Location end;

    public Location getStart(){

        return this.start;
    }
    public Location getEnd(){

        return this.end;
    }


    public Segment(Location start, Location end) throws LocationNotAlignedException {
        int dY = end.getCol() - start.getCol();
        int dX = end.getRow() - start.getRow();
        if (start.getCol() == end.getCol() || start.getRow() == end.getRow() || Math.abs(dX) == Math.abs(dY)){
        this.start = start;
        this.end = end;
        }else throw new LocationNotAlignedException("start and end do not align");
    }

    public int length(){ //length of a segment
        int dY = end.getCol() - start.getCol();
        int dX = end.getRow() - start.getRow();
        if (end.getCol() == start.getCol()){
            return  Math.abs(end.getRow() - start.getRow()) +1;
        }else if (end.getRow() == start.getRow()){
            return Math.abs(end.getCol() - start.getCol()) +1;
        }else if ( dX == dY){
            return Math.abs(end.getRow() - start.getRow()) +1;
        }
        return 0;
    }
}
