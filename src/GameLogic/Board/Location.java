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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;

        if (getRow() != location.getRow()) return false;
        return getCol() == location.getCol();

    }

    @Override
    public int hashCode() {
        int result = getRow();
        result = 31 * result + getCol();
        return result;
    }
}
