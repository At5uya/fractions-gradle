public class Fraction implements IFraction {

    private final Integer numerator;
    private final Integer denominator;

    public Fraction(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        if (denominator == 0) throw new ArithmeticException("Cannot Divide by 0");
    }

    @Override
    public Integer getNumerator() {
        return numerator;
    }

    @Override
    public Integer getDenominator() {
        return denominator;
    }

    @Override
    public IFraction plus(IFraction other) {
        int num = this.numerator;
        int den = this.denominator;
        int oNum = other.getNumerator();
        int oDen = other.getDenominator();
        if (den == oDen){
            return createNormalised(num + oNum, den);
        } else {
            int bigNum = oDen * num + den * oNum;
            int bigDen = oDen * den;
            return createNormalised(bigNum, bigDen);
        }
    }

    @Override
    public IFraction minus(IFraction other) {
        int num = this.numerator;
        int den = this.denominator;
        int oNum = other.getNumerator();
        int oDen = other.getDenominator();
        if (den == oDen){
            return new Fraction(num + oNum, den);
        } else {
            int bigNum = oDen * num - den * oNum;
            int bigDen = oDen * den;
            return createNormalised(bigNum, bigDen);
        }
    }

    @Override
    public IFraction times(IFraction other) {
        return createNormalised((this.numerator * other.getNumerator()), (this.denominator * other.getDenominator()));
    }

    @Override
    public IFraction dividedBy(IFraction other) {
        Fraction twisted = new Fraction(other.getDenominator(), other.getNumerator());
        return this.times(twisted);
    }

    public static Fraction createNormalised(Integer numerator, Integer denominator) {
        int gdc = Utils.findGDC(denominator, numerator);
        Fraction normal = new Fraction(numerator / gdc, denominator / gdc);
        return normal;
    }

    @Override
    public String toString() {
        return "Fraction " + numerator + "/" + denominator;
    }
}
