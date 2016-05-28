package GameLogic.Expression.Operator;

import GameLogic.Expression.Operand.Operand;

/**
 * Created by Haimo Zhang on 5/28/2016.
 */
public class DivideOperator implements Operator{


    @Override
    public Operand apply(Operand a, Operand b) {
        Operand negB = new Operand(b.getDenominator(),b.getNumerator());
        MultiplyOperator op = new MultiplyOperator();
        negB.simplify();
        return op.apply(a,negB);
    }
}
