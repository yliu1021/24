package GameLogic.Expression.Operator.Tests;

import GameLogic.Expression.Operand.Operand;
import GameLogic.Expression.Operator.Operator;

/**
 * Created by Anthony Xiang on 5/28/2016.
 */
public class SubtractOperatorTest {
        public static void test() {

            System.out.println("Testing simple subtraction");
            simpleTest();
            System.out.println("Testing simplifying fractions");
            simplifyTest();

        }

        public static void simpleTest() {
            Operand op1 = new Operand(1);
            Operand op2 = new Operand(4);
            Operator op = new GameLogic.Expression.Operator.SubtractOperator();

            Operand result = op.apply(op1, op2);
            assert result.getNumerator() == -3 && result.getDenominator() == 1 : "im retarded";
        }

        public static void simplifyTest() {
            Operand op1 = new Operand(5, 4);
            Operand op2 = new Operand(9, 7);
            Operator op = new GameLogic.Expression.Operator.SubtractOperator();

            Operand result = op.apply(op1, op2);
            assert result.getNumerator() == 1 && result.getDenominator() == -28: "Did not get expected results";
        }

        public static void main(String[] args) {
            System.out.println("Testing...");
            test();
            System.out.println("Tests complete");
        }
    }
