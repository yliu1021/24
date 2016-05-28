package GameLogic.Expression.Operator;

import GameLogic.Expression.Operand.Operand;


public interface Operator {
    public Operand apply(Operand a, Operand b);
}
