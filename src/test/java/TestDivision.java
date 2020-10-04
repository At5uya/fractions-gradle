import org.junit.Assert;
import org.junit.Test;

public class TestDivision {
    @Test
    public void testSimple() {
        var fraction = TestUtils.createFraction(5, 18);
        var result = fraction.dividedBy(new NotImplementedFraction(8, 27));

        Assert.assertEquals((Integer) 15, result.getNumerator());
        Assert.assertEquals((Integer) 16, result.getDenominator());
    }
}
