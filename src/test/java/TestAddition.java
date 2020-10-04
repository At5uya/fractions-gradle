import org.junit.Assert;
import org.junit.Test;


public class TestAddition {

    @Test
    public void testSimple() {
        var fraction = TestUtils.createFraction(5, 18);
        var result = fraction.plus(new NotImplementedFraction(8, 27));

        Assert.assertEquals((Integer) 31, result.getNumerator());
        Assert.assertEquals((Integer) 54, result.getDenominator());
    }

    @Test
    public void testNormalisation() {
        var fraction = TestUtils.createFraction(1, 2);
        var result = fraction.plus(new NotImplementedFraction(1, 2));

        Assert.assertEquals((Integer) 1, result.getNumerator());
        Assert.assertEquals((Integer) 1, result.getDenominator());
    }
}
