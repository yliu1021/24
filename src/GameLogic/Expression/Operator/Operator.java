package GameLogic.Expression.Operator;

import GameLogic.Expression.Operand.Operand;


public interface Operator {

    int getPrecedence();

    Operand apply(Operand a, Operand b);

    @Override
    public String toString();
}
