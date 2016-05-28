package GameLogic.Expression.Operand;

/**
 * Created by Yuhan on 5/28/16.
 */
public class Operand {
    private int value;

    public Operand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
