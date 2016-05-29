package GameLogic.Expression.Operand;

public class Operand {
    private int numerator;
    private int denominator;

    public Operand(int num) {
        numerator = num;
        denominator = 1;
    }

    public Operand(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Can't set denominator to 0");
        }
        this.denominator = denominator;
    }

    public void simplify() {
        int gcf = gcf(numerator, denominator);
        numerator /= gcf;
        denominator /= gcf;

        if (numerator > 0 && denominator < 0)
        {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    private int gcf(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    @Override
    public String toString() {
        return "Operand{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operand operand = (Operand) o;

        return numerator == operand.numerator && denominator == operand.denominator;

    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }
}
