package GameLogic.Expression;

import GameLogic.Expression.Operand.Operand;
import GameLogic.Expression.Operator.*;

/**
 * Created by Anthony Xiang on 5/28/2016.
 */
public class ExpressionTest {
    public static void main (String[] args) {
    //2 * 13 - 1555
        Operand op1 = new Operand(3);
        Operator multiply = new DivideOperator();
        Operand op2 = new Operand(11);
        Operator subtract = new DivideOperator();
        Operand op3 = new Operand(2);
        Expression e = new Expression();
        e.addOperand(op1);
        e.addOperator(multiply);
        e.addOperand(op2);
        e.addOperator(subtract);
        e.addOperand(op3);
        System.out.println(e.evaluate().toString());
    }
}