package GameLogic.Expression.Operator;

import GameLogic.Expression.Operand.Operand;

/**
 * Created by Haimo Zhang on 5/28/2016.
 */
public class SubtractOperator implements Operator{
    public Operand apply(Operand a, Operand b){
        Operand negB = new Operand(-b.getNumerator(),b.getDenominator());
        AddOperator a1 = new AddOperator();
        negB.simplify();
        return a1.apply(a,negB);

// negative is on the denominator
    }
}
