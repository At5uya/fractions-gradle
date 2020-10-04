import org.junit.Assert;
import org.junit.Test;

public class TestMultiplication {
    @Test
    public void testSimple() {
        var fraction = TestUtils.createFraction(5, 18);
        var result = fraction.times(new NotImplementedFraction(8, 27));

        Assert.assertEquals((Integer) 20, result.getNumerator());
        Assert.assertEquals((Integer) 243, result.getDenominator());
    }
}
