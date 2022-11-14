import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HugeIntegerTest {
    private HugeInteger hugeInteger;

    @BeforeEach
    void setUp(){
        hugeInteger = new HugeInteger("234567");
    }
    @Test
    void testThatHugeIntegerObjectExist(){
        assertNotNull(hugeInteger);
    }
    @Test
    void testThatParseMethodConvertsCharactersInStringToIntegerAndUsesTheIntegerValuesToFillTheArrayIndexesRespectively(){
        int [] numbers = hugeInteger.getNumbers();
        assertEquals(numbers[0], 2);
        assertEquals(numbers[1], 3);
    }

    @Test
    void testThatExceptionIsThrownIfLetterIsContainedInString(){
        assertThrows(NumberFormatException.class, ()-> hugeInteger.parse("123edfrt345"));
    }
    @Test
    void testThatExceptionIsThrownIfStringLengthIsGreaterThanForty(){
        StringBuilder s = new StringBuilder();
        for (int i = 1; i < 40; i++) {
            s.append(i);
        }
        assertThrows(RuntimeException.class, ()-> hugeInteger.parse(String.valueOf(s)));
    }

    @Test
    void testThatToStringReturnsArrayValuesInStringFormat(){
        hugeInteger.parse("12321456");
//        System.out.println(Arrays.toString(hugeInteger.getNumbers()));
        String string = hugeInteger.toString();
//        System.out.println(string);
        assertEquals("1232145600000000000000000000000000000000",string);
    }

    @Test
    void testThatHugeIntegerObjectCanBeAdded(){
        HugeInteger hugeInteger1 = new HugeInteger("123456789");
        HugeInteger hugeInteger2 = new HugeInteger("234567898");
        HugeInteger sumOfHugeInteger = HugeInteger.add(hugeInteger1, hugeInteger2);
        int [] sum = sumOfHugeInteger.getNumbers();
//        System.out.println(Arrays.toString(sum));
        assertEquals(3,sum[0]);
        assertEquals(5,sum[1]);
        assertEquals(8,sum[2]);
        assertEquals(0,sum[3]);
        assertEquals(2,sum[4]);
        assertEquals(8,sum[7]);
        assertEquals(7,sum[8]);
    }
    @Test
    void testThatHugeIntegerObjectCanBeSubtracted(){
        HugeInteger hugeInteger1 = new HugeInteger("2007");
        HugeInteger hugeInteger2 = new HugeInteger("8999");
        HugeInteger diffOfHugeInteger = HugeInteger.sub(hugeInteger1, hugeInteger2);
        int [] diff = diffOfHugeInteger.getNumbers();
//        System.out.println(Arrays.toString(diff));
        assertEquals(-7, diff[0]);
        assertEquals(0, diff[1]);
        assertEquals(0, diff[2]);
        assertEquals(8, diff[3]);
    }

    @Test
    void testThatTrueIsReturnedIfHugeIntegerOneIsGreaterThanHugeIntegerTwoWhenIsGreaterThanMethodIsInvoked(){
        HugeInteger hugeInteger1 = new HugeInteger("9011");
        HugeInteger hugeInteger2 = new HugeInteger("9001");
        boolean isGreater = HugeInteger.isGreaterThan(hugeInteger1, hugeInteger2);
        assertTrue(isGreater);
    }
    @Test
    void testThatFalseIsReturnedIfHugeIntegerOneIsLessThanOrEqualToHugeIntegerTwoWhenIsGreaterThanMethodIsInvoked(){
        HugeInteger hugeInteger1 = new HugeInteger("7956");
        HugeInteger hugeInteger2 = new HugeInteger("8957");
        boolean isGreater = HugeInteger.isGreaterThan(hugeInteger1, hugeInteger2);
        assertFalse(isGreater);

    }
    @Test
    void testThatTrueIsReturnedIfHugeIntegerOneIsLessThanHugeIntegerTwoWhenIsLessThanMethodIsInvoked(){
        HugeInteger hugeInteger1 = new HugeInteger("8011");
        HugeInteger hugeInteger2 = new HugeInteger("9001");
        boolean isLess = HugeInteger.isLessThan(hugeInteger1, hugeInteger2);
        assertTrue(isLess);
    }

    @Test
    void testThatFalseIsReturnedIfHugeIntegerOneIsGreaterThanOrEqualToHugeIntegerTwoWhenIsLessThanMethodIsInvoked(){
        HugeInteger hugeInteger1 = new HugeInteger("9956");
        HugeInteger hugeInteger2 = new HugeInteger("8957");
        boolean isLess = HugeInteger.isLessThan(hugeInteger1, hugeInteger2);
        assertFalse(isLess);
    }
    @Test
    void testThatTrueIsReturnedIfHugeIntegerOneIsEqualHugeIntegerTwoWhenIsEqualMethodIsInvoked(){
        HugeInteger hugeInteger1 = new HugeInteger("9001");
        HugeInteger hugeInteger2 = new HugeInteger("9001");
        boolean isEqual = HugeInteger.isEqual(hugeInteger1, hugeInteger2);
        assertTrue(isEqual);
    }
    @Test
    void testThatFalseIsReturnedIfHugeIntegerOneIsNotEqualHugeIntegerTwoWhenIsEqualMethodIsInvoked() {
        HugeInteger hugeInteger1 = new HugeInteger("9956");
        HugeInteger hugeInteger2 = new HugeInteger("8957");
        boolean isEqual = HugeInteger.isEqual(hugeInteger1, hugeInteger2);
        assertFalse(isEqual);
    }
    @Test
    void testThatTrueIsReturnedIfHugeIntegerOneIsNotEqualHugeIntegerTwoWhenIsNotEqualMethodIsInvoked(){
        HugeInteger hugeInteger1 = new HugeInteger("8000");
        HugeInteger hugeInteger2 = new HugeInteger("8001");
        boolean isNotEqual = HugeInteger.isNotEqual(hugeInteger1, hugeInteger2);
        assertTrue(isNotEqual);
    }

    @Test
    void testThatFalseIsReturnedIfHugeIntegerOneIsEqualHugeIntegerTwoWhenIsNotEqualMethodIsInvoked(){
        HugeInteger hugeInteger1 = new HugeInteger("8000");
        HugeInteger hugeInteger2 = new HugeInteger("8000");
        boolean isNotEqual = HugeInteger.isNotEqual(hugeInteger1, hugeInteger2);
        assertFalse(isNotEqual);
    }

}