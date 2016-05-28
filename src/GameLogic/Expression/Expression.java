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

    void addOperand(Operand op) throws CorruptExpressionListException {
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

    void addOperator(Operator op) throws CorruptExpressionListException {
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

    Operand evaluate() throws CorruptExpressionListException {
        return evaluate(ops);
    }

    private Operand evaluate(List l) throws CorruptExpressionListException {
        if (l.size() < 3) {
            throw new CorruptExpressionListException("Not enough operators/operands");
        }
        if (l.size() == 3) {
            Operand op1;
            Operand op2;
            Operator operator;
            Object o = l.get(0);
            if (o instanceof Operand) {
                op1 = (Operand) o;
            } else {
                throw new CorruptExpressionListException("Operand not at beginning of list");
            }
            o = l.get(1);
            if (o instanceof Operator) {
                operator = (Operator) o;
            } else {
                throw new CorruptExpressionListException("Operator not in between 2 operators");
            }
            o = l.get(2);
            if (o instanceof Operand) {
                op2 = (Operand) o;
            } else {
                throw new CorruptExpressionListException("Operand not at the end of list");
            }
            return operator.apply(op1, op2);
        }
        int operatorInd = 1;
        Object o = l.get(1);
        Operator operator;
        if (o instanceof Operator)
            operator = (Operator)l.get(1);
        else
            throw new CorruptExpressionListException("Operator not found");

        for (int i = 3; i < l.size(); i += 2) {
            o = l.get(i);
            if (o instanceof Operator) {
                Operator op = (Operator) o;
                if (operator.getPrecedence() < op.getPrecedence()) {
                    operatorInd = i;
                    operator = op;
                }
            }
        }
        return null;
    }

    void clear() {
        ops = new ArrayList<>();
    }

}
