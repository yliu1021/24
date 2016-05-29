package GameLogic.Board;

import GameLogic.Board.Occupants.Blocker;
import GameLogic.Board.Occupants.Number;
import GameLogic.Board.Occupants.Occupant;
import GameLogic.Expression.Expression;
import GameLogic.Expression.Operand.Operand;
import GameLogic.Player;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static Operand goal = new Operand(24);
    private static Operand penalty = new Operand(28);

    private Player player1 = new Player();
    private Player player2 = new Player();
    private Occupant[][] occupants;

    public Board(int size){
        occupants = new Occupant[size][size];
        //TODO: gen random blockers
    }

    public boolean canAdd(Location l, Player p) {
        int row = l.getRow();
        int col = l.getCol();
        return occupants[row][col] == null;
    }

    public boolean setOccupant(Occupant o, Location l, Player p) {
        if (!canAdd(l, p)) {
            return false;
        }
        int row = l.getRow();
        int col = l.getCol();
        occupants[row][col] = o;
        List<Segment> s = evaluate();
        for (Segment segment : s) {
            Location start = segment.getStart();
            int r = start.getRow();
            int c = start.getCol();
            Expression horizontalExpression = getHorizontalExpression(r, c);
            if (horizontalExpression.evaluate().equals(goal)) {
                p.incrementScore(horizontalExpression.length());
            } else if (horizontalExpression.evaluate().equals(penalty)) {
                p.incrementScore(-horizontalExpression.length());
            }
            Expression verticalExpression = getVerticalExpression(r, c);
            if (verticalExpression.evaluate().equals(goal)) {
                p.incrementScore(verticalExpression.length());
            } else if (horizontalExpression.evaluate().equals(penalty)) {
                p.incrementScore(-verticalExpression.length());
            }
        }
        clear(s);
        return true;
    }

    private List<Segment> evaluate() {
        List<Segment> results = new ArrayList<>();

        for (int row = 0; row < occupants.length; row++) {
            for (int col = 0; col < occupants[row].length; col++) {
                Occupant o = occupants[row][col];
                if (o instanceof Number) {
                    Expression horizontalExpression = getHorizontalExpression(row, col);
                    Operand value = horizontalExpression.evaluate();
                    if (value.equals(goal) || value.equals(penalty)) {
                        Location start = new Location(row, col);
                        Location end = new Location(row, col + horizontalExpression.length());
                        Segment segment = new Segment(start, end);
                        results.add(segment);
                    }
                    Expression verticalExpression = getVerticalExpression(row, col);
                    value = verticalExpression.evaluate();
                    if (value.equals(goal) || value.equals(penalty)) {
                        Location start = new Location(row, col);
                        Location end = new Location(row + verticalExpression.length(), col);
                        Segment segment = new Segment(start, end);
                        results.add(segment);
                    }
                }
            }
        }

        return results;
    }

    private Expression getHorizontalExpression(int row, int col) {
        Expression e = new Expression();
        for (; col < occupants[row].length; col++) {
            Occupant o = occupants[row][col];
            if (o != null && !(o instanceof Blocker)) {
                e.add(o);
            } else {
                break;
            }
        }
        return e;
    }

    private Expression getVerticalExpression(int row, int col) {
        Expression e = new Expression();
        for (; row < occupants.length; row++) {
            Occupant o = occupants[row][col];
            if (o != null && !(o instanceof Blocker)) {
                e.add(o);
            } else {
                break;
            }
        }
        return e;
    }

    private void clear(List<Segment> segments) {
        for (Segment segment : segments) {
            Location start = segment.getStart();
            Location end = segment.getEnd();
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

    public int getScore(Player p) {
        return p.getScore();
    }

}
