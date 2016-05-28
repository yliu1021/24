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

    void addOperand(Operand op) throws AddOpException {
        if (ops.isEmpty()) {
            ops.add(op);
            return;
        }

        Object last = ops.get(ops.size() - 1);
        if (last instanceof Operator) {
            ops.add(op);
        } else {
            throw new AddOpException("Cannot add an operand after another operand");
        }
    }

    void addOperator(Operator op) throws AddOpException {
        if (ops.isEmpty()) {
            throw new AddOpException("Cannot add operator to an empty expression");
        }

        Object last = ops.get(ops.size() - 1);
        if (last instanceof Operand) {
            ops.add(op);
        } else {
            throw new AddOpException("Cannot add an operator after another operator");
        }
    }

    Operand evaluate() {
        return evaluate(ops);
    }

    private Operand evaluate(List l) {
        if (l.size() < 3) {
            throw new InvalidExpressionEvaluationException("")
        }
        for (Object o : l) {
            if (o instanceof Operator) {

            }
        }
    }

    void clear() {
        ops = new ArrayList<>();
    }

}
