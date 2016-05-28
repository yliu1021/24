package GameLogic.Expression.Operator;

import GameLogic.Expression.Operand.Operand;

/**
 * Created by Haimo Zhang on 5/28/2016.
 */
public class DivideOperator implements Operator{

    private int precedence;

    public DivideOperator(int precedence) {
        this.precedence = precedence;
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }

    @Override
    public Operand apply(Operand a, Operand b) {
        Operand negB = new Operand(b.getDenominator(),b.getNumerator());
        MultiplyOperator op = new MultiplyOperator(precedence);
        negB.simplify();
        return op.apply(a,negB);

        // negative is on the denominator
    }
}
