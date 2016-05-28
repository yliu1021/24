package GameLogic.Expression.Operator;

import GameLogic.Expression.Operand.Operand;

public class MultiplyOperator implements Operator{


    @Override
    public Operand apply(Operand a, Operand b) {
        int n1 = a.getNumerator();
        int n2 = b.getNumerator();
        int d1 = a.getDenominator();
        int d2 = b.getDenominator();
        Operand op = new Operand(n1*n2,d1*d2);
        op.simplify();
        return op;
    }
}
