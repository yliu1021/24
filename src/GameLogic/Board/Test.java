package GameLogic.Board;

/**
 * Created by Haimo Zhang on 5/28/2016.
 */
public class Test {
    public static void main(String[] args){
        Location start = new Location(1,4);
        Location end = new Location(3,6);
        Segment s = null;
        try{
            s = new Segment(start,end);
        }catch(LocationNotAligned e) {
            System.out.printf("thrown exception");
        }
        System.out.println(s.length()); //3

    }


}
