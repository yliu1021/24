package GameLogic.Expression.Operator.Tests;

import GameLogic.Expression.Operand.Operand;
import GameLogic.Expression.Operator.AddOperator;
import GameLogic.Expression.Operator.Operator;

/**
 * Created by Yuhan on 5/28/16.
 */
public class AddOperatorTest {

    public static void test() {

        System.out.println("Testing simple addition");
        simpleTest();
        System.out.println("Testing simplifying fractions");
        simplifyTest();

    }

    public static void simpleTest() {
        Operand op1 = new Operand(3);
        Operand op2 = new Operand(4);
        Operator op = new AddOperator();

        Operand result = op.apply(op1, op2);
//        assert result.getNumerator() == 7 && result.getDenominator() == 1;
    }

    public static void simplifyTest() {
        Operand op1 = new Operand(3, 4);
        Operand op2 = new Operand(4, 8);
        Operator op = new AddOperator();

        Operand result = op.apply(op1, op2);
        assert result.getNumerator() == 41 && result.getDenominator() == 35 : "Did not get expected results";
    }

    public static void main(String[] args) {
        System.out.println("Testing...");
        test();
        System.out.println("Tests complete");
    }

}