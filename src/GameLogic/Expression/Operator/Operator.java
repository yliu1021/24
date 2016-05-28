package GameLogic.Expression.Operator;

import GameLogic.Expression.Operand.Operand;

/**
 * Created by Yuhan on 5/28/16.
 */
public interface Operator {
    public Operand apply(Operand a, Operand b);
}
