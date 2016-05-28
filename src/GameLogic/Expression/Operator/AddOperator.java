package GameLogic.Expression.Operator;

import GameLogic.Expression.Operand.Operand;


public class AddOperator implements Operator{

    private int precedence;

    public AddOperator(int precedence) {
        this.precedence = precedence;
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }

    @Override
    public Operand apply(Operand a, Operand b){
        int d1 = a.getDenominator();
        int d2 = b.getDenominator();
        int n1 = a.getNumerator();
        int n2 = b.getNumerator();
        Operand fraction = new Operand((n1*d2 + n2*d1 ), d1*d2);
        fraction.simplify();
        return fraction;

        // negative is on the numerator
    }
}
