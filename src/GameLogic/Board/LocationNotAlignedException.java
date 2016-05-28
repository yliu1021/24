package GameLogic.Board;

/**
 * Created by Haimo Zhang on 5/28/2016.
 */
public class LocationNotAlignedException extends RuntimeException{
    public LocationNotAlignedException() {
        super();
    }

    public LocationNotAlignedException(String message) {
        super(message);
    }
}
