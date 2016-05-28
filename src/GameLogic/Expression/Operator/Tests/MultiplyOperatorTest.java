package GameLogic.Expression.Operator.Tests;

import GameLogic.Expression.Operand.Operand;
import GameLogic.Expression.Operator.MultiplyOperator;
import GameLogic.Expression.Operator.Operator;

/**
 * Created by Anthony Xiang on 5/28/2016.
 */
public class MultiplyOperatorTest {
        public static void test() {

            System.out.println("Testing simple subtraction");
            simpleTest();
            System.out.println("Testing simplifying fractions");
            simplifyTest();

        }

        public static void simpleTest() {
            Operand op1 = new Operand(20);
            Operand op2 = new Operand(3);
            Operator op = new MultiplyOperator();

            Operand result = op.apply(op1, op2);
            System.out.println(result.getNumerator());
            System.out.println(result.getDenominator());
        }

        public static void simplifyTest() {
            Operand op1 = new Operand(5, 4);
            Operand op2 = new Operand(2, 3);
            Operator op = new MultiplyOperator();

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
