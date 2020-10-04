
public class NotImplementedFraction implements IFraction{

    private final int numerator;
    private final int denominator;

    public NotImplementedFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
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
            return new NotImplementedFraction(num + oNum, den).normalise();
        } else {
            int bigNum = oDen * num + den * oNum;
            int bigDen = oDen * den;
            int gdc = Utils.findGDC(bigDen, bigNum);
            return new NotImplementedFraction(bigNum / gdc, bigDen / gdc).normalise();
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
            int gdc = Utils.findGDC(bigDen, bigNum);
            return new NotImplementedFraction(bigNum / gdc, bigDen / gdc).normalise();
        }
    }

    @Override
    public IFraction times(IFraction other) {
        return new NotImplementedFraction((this.numerator * other.getNumerator()), (this.denominator * other.getDenominator())).normalise();
    }

    @Override
    public IFraction dividedBy(IFraction other) {
        NotImplementedFraction twisted = new NotImplementedFraction(other.getDenominator(), other.getNumerator());
        return this.times(twisted);
    }

    public IFraction normalise() {
        int gdc = TestUtils.findGDC(this.denominator, this.numerator);
        NotImplementedFraction normal = new NotImplementedFraction(this.numerator / gdc, this.denominator / gdc);
        return normal;
    }
}
