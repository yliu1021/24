package GameLogic;

import GameLogic.Expression.Operator.Operator;
import GameLogic.Powerups.Powerup;

import java.util.ArrayList;
import java.util.List;

public class Player {

    List<Operator> validOperators = new ArrayList<>();
    List<Powerup> validPowerups = new ArrayList<>();

    private double timePenalty;
    private int numWins;

    private int score;

    public Player(){
        this.timePenalty = 0;

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementScore(int value) {
        score += value;
    }

}
