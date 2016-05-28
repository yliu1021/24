package GameLogic;

import GameLogic.Expression.Expression;
import GameLogic.Expression.Operator.Operator;
import GameLogic.Powerups.Powerup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuhan on 5/28/16.
 */
public class Player {

    List<Operator> validOperators = new ArrayList();
    List<Powerup> validPowerups = new ArrayList();
    Expression expression;

    int score = 0;
    double timePenalty = 0.0;

    public int getScore() {

    }

    public int getExpressionValue() {

    }
}
