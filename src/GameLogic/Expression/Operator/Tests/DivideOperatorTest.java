package GameLogic.Expression.Operator.Tests;

import GameLogic.Expression.Operand.Operand;
import GameLogic.Expression.Operator.AddOperator;
import GameLogic.Expression.Operator.DivideOperator;
import GameLogic.Expression.Operator.Operator;

/**
 * Created by Anthony Xiang on 5/28/2016.
 */
public class DivideOperatorTest {

    public static void test() {

        System.out.println("Testing simple addition");
        simpleTest();
        System.out.println("Testing simplifying fractions");
        simplifyTest();

    }

    public static void simpleTest() {
        Operand op1 = new Operand(3);
        Operand op2 = new Operand(0);
        Operator op = new DivideOperator();

        Operand result = op.apply(op1, op2);
        System.out.println(result.getNumerator());
        System.out.println(result.getDenominator());
    }

    public static void simplifyTest() {
        Operand op1 = new Operand(2, 4);
        Operand op2 = new Operand(87,32);
        Operator op = new DivideOperator();

        Operand result = op.apply(op1, op2);
        System.out.println(result.getNumerator());
        System.out.println(result.getDenominator());
    }

    public static void main(String[] args) {
        System.out.println("Testing...");
        test();
        System.out.println("Tests complete");
    }

}
