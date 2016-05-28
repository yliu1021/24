package GameLogic.Expression;

import GameLogic.Expression.Operand.Operand;
import GameLogic.Expression.Operator.Operator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuhan on 5/28/16.
 */
public class Expression {

    private List<Object> ops;

    public Expression() {
        ops = new ArrayList<>();
    }

    void addOperand(Operand op) {
        if (ops.isEmpty()) {
            ops.add(op);
            return;
        }

        Object last = ops.get(ops.size() - 1);
        if (last instanceof Operator) {
            ops.add(op);
        } else {
            throw new CorruptExpressionListException("Cannot add an operand after another operand");
        }
    }

    void addOperator(Operator op) {
        if (ops.isEmpty()) {
            throw new CorruptExpressionListException("Cannot add operator to an empty expression");
        }

        Object last = ops.get(ops.size() - 1);
        if (last instanceof Operand) {
            ops.add(op);
        } else {
            throw new CorruptExpressionListException("Cannot add an operator after another operator");
        }
    }

    Operand evaluate() {
        return evaluate(ops, 0, ops.size());
    }

    private Operand evaluate(List l, int start, int end) {
        if (end - start == 1) {
            return (Operand)l.get(start);
        }
        if (end - start < 3) {
            throw new CorruptExpressionListException("Not enough operators/operands");
        }
        if (end - start == 3) {
            Operand op1;
            Operand op2;
            Operator operator;
            Object o = l.get(start);
            if (o instanceof Operand) {
                op1 = (Operand) o;
            } else {
                throw new CorruptExpressionListException("Operand not at beginning of list");
            }
            o = l.get(start+1);
            if (o instanceof Operator) {
                operator = (Operator) o;
            } else {
                throw new CorruptExpressionListException("Operator not in between 2 operators");
            }
            o = l.get(start+2);
            if (o instanceof Operand) {
                op2 = (Operand) o;
            } else {
                throw new CorruptExpressionListException("Operand not at the end of list");
            }
            return operator.apply(op1, op2);
        }
        int operatorInd = start + 1;
        Object o = l.get(start + 1);
        Operator operator;
        if (o instanceof Operator)
            operator = (Operator)o;
        else
            throw new CorruptExpressionListException("Operator not found");

        for (int i = start+3; i < end; i += 2) {
            o = l.get(i);
            if (o instanceof Operator) {
                Operator op = (Operator) o;
                if (operator.getPrecedence() >= op.getPrecedence()) {
                    operatorInd = i;
                    operator = op;
                }
            } else {
                throw new CorruptExpressionListException("Operator not in right place");
            }
        }

        Operand right = evaluate(l, operatorInd + 1, end);
        Operand left = evaluate(l, 0, operatorInd);
        return operator.apply(left, right);
    }

    void clear() {
        ops = new ArrayList<>();
    }

}
