package GameLogic.Expression.Operator;

import GameLogic.Expression.Operand.Operand;

/**
 * Created by Haimo Zhang on 5/28/2016.
 */
public class DivideOperator implements Operator{

    private int precedence;

    public DivideOperator() {
        this(10);
    }

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
        if (b.getNumerator() == 0) {
            throw new IllegalArgumentException("Dividing by 0");
        }
        Operand negB = new Operand(b.getDenominator(),b.getNumerator());
        MultiplyOperator op = new MultiplyOperator(precedence);
        negB.simplify();
        return op.apply(a,negB);

    }
}
