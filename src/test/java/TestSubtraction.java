import org.junit.Assert;
import org.junit.Test;


public class TestSubtraction {

    @Test
    public void simple(){
        var fraction = TestUtils.createFraction(5, 18);
        var result = fraction.minus(new NotImplementedFraction(8, 27));

        Assert.assertEquals((Integer) 1, result.getNumerator());
        Assert.assertEquals((Integer) (-54), result.getDenominator());
    }



}
