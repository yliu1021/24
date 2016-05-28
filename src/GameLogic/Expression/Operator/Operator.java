package GameLogic.Expression.Operator;

import GameLogic.Expression.Operand.Operand;


public interface Operator {
    Operand apply(Operand a, Operand b);
}
