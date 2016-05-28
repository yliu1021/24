package GameLogic.Board.Occupants;

import GameLogic.Board.Location;

/**
 *
 * @author James
 */
public class Blocker implements Occupant {

    private Location location;

    public Blocker(Location location) {
        this.location = location;
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
