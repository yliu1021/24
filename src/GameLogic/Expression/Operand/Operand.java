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
}
