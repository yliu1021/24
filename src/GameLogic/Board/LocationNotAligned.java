package GameLogic.Board;

/**
 * Created by Haimo Zhang on 5/28/2016.
 */
public class LocationNotAligned extends Exception{
    public LocationNotAligned() {
        super();
    }

    public LocationNotAligned(String message) {
        super(message);
    }
}
