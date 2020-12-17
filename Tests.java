import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test(expected = NullPointerException.class)
    public void testNull() {
        Integer.decode(null);
    }

    @Test(expected = NumberFormatException.class)
    public void testEmptyString() {
        Integer.decode("");
    }

    @Test(expected = NumberFormatException.class)
    public void testWord() {
        Integer.decode("word");
    }

    @Test(expected = NumberFormatException.class)
    public void testDouble() {
        Integer.decode("3.14");
    }

    @Test(expected = NumberFormatException.class)
    public void testLong() {
        Integer.decode("10000000000");
    }

    @Test(expected = NumberFormatException.class)
    public void testTwoNumbers() {
        Integer.decode("15 16");
    }

    @Test
    public void testPositive() {
        Assert.assertEquals(1341, Integer.decode("1341").longValue());
    }

    @Test
    public void testNegative() {
        Assert.assertEquals(-197, Integer.decode("-197").longValue());
    }

    @Test
    public void testPositiveWithPlusSign() {
        Assert.assertEquals(984, Integer.decode("+984").longValue());
    }

    @Test(expected = NumberFormatException.class)
    public void testPlusMinusSign() {
        Integer.decode("+-1");
    }

    @Test(expected = NumberFormatException.class)
    public void testSignBetweenNumbers() {
        Integer.decode("1-1");
    }

    @Test(expected = NumberFormatException.class)
    public void testSignSpaces() {
        Integer.decode("- 1");
    }

    @Test
    public void testOctNumSystem() {
        Assert.assertEquals(83, Integer.decode("0123").longValue());
    }

    @Test(expected =  NumberFormatException.class)
    public void testNotOctNumber() {
        Integer.decode("0128");
    }

    @Test
    public void testMaxValue(){
        Assert.assertEquals(Integer.MAX_VALUE, Integer.decode("2147483647").longValue());
    }

    @Test
    public void testMinValue(){
        Assert.assertEquals(Integer.MIN_VALUE, Integer.decode("-2147483648").longValue());
    }

}