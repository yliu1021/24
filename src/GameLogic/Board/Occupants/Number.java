package GameLogic.Board.Occupants;

import GameLogic.Board.Location;
import GameLogic.Expression.Operand.Operand;

/**
 *
 * @author James
 */
public class Number implements Occupant{

    private Location location;

    private Operand value;

    public Number(Location location, Operand operand) {
        this.location = location;
        this.value = operand;
    }

    public Operand getValue() {
        return value;
    }

    public void setValue(Operand value) {
        this.value = value;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }
}
