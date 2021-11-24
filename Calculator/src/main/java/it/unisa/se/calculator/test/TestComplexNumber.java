package it.unisa.se.calculator.test;
import static org.junit.Assert.*;

import it.unisa.se.calculator.model.ComplexNumber;
import org.junit.Test;

public class TestComplexNumber {
    @Test
    public void testSum(){
        ComplexNumber result = ComplexNumber.sum(new ComplexNumber(3.0,7.0), new ComplexNumber(-7.0,3.0) );
        assertEquals(result, new ComplexNumber(-4.0, 10.0));
        ComplexNumber result2 = ComplexNumber.sum(new ComplexNumber(3.0,7.0), new ComplexNumber(7.0,3.0) );
        assertEquals(result2, new ComplexNumber(10.0, 10.0));
        ComplexNumber result3 = ComplexNumber.sum(new ComplexNumber(3.0,7.0), new ComplexNumber(7.0,-3.0) );
        assertEquals(result3, new ComplexNumber(10.0, 4.0));
        ComplexNumber result4 = ComplexNumber.sum(new ComplexNumber(3.0,7.0), new ComplexNumber(-7.0,-3.0) );
        assertEquals(result4, new ComplexNumber(-4.0,4.0));

        result = ComplexNumber.sum(new ComplexNumber(-3.0,7.0), new ComplexNumber(-7.0,3.0) );
        assertEquals(result, new ComplexNumber(-10.0, 10.0));
        result2 = ComplexNumber.sum(new ComplexNumber(-3.0,7.0), new ComplexNumber(7.0,3.0) );
        assertEquals(result2, new ComplexNumber(4.0, 10.0));
        result3 = ComplexNumber.sum(new ComplexNumber(-3.0,7.0), new ComplexNumber(7.0,-3.0) );
        assertEquals(result3, new ComplexNumber(4.0, 4.0));
        result4 = ComplexNumber.sum(new ComplexNumber(-3.0,7.0), new ComplexNumber(-7.0,-3.0) );
        assertEquals(result4, new ComplexNumber(-10.0, 4.0));

        result = ComplexNumber.sum(new ComplexNumber(3.0,-7.0), new ComplexNumber(-7.0,3.0) );
        assertEquals(result, new ComplexNumber(-4.0, -4.0));
        result2 = ComplexNumber.sum(new ComplexNumber(3.0,-7.0), new ComplexNumber(7.0,3.0) );
        assertEquals(result2, new ComplexNumber(10.0, -4.0));
        result3 = ComplexNumber.sum(new ComplexNumber(3.0,-7.0), new ComplexNumber(7.0,-3.0) );
        assertEquals(result3, new ComplexNumber(10.0, -10.0));
        result4 = ComplexNumber.sum(new ComplexNumber(3.0,-7.0), new ComplexNumber(-7.0,-3.0) );
        assertEquals(result4, new ComplexNumber(-4.0, -10.0));

        result = ComplexNumber.sum(new ComplexNumber(-3.0,-7.0), new ComplexNumber(-7.0,3.0) );
        assertEquals(result, new ComplexNumber(-10.0, -4.0));
        result2 = ComplexNumber.sum(new ComplexNumber(-3.0,-7.0), new ComplexNumber(7.0,3.0) );
        assertEquals(result2, new ComplexNumber(4.0, -4.0));
        result3 = ComplexNumber.sum(new ComplexNumber(-3.0,-7.0), new ComplexNumber(7.0,-3.0) );
        assertEquals(result3, new ComplexNumber(4.0, -10.0));
        result4 = ComplexNumber.sum(new ComplexNumber(-3.0,-7.0), new ComplexNumber(-7.0,-3.0) );
        assertEquals(result4, new ComplexNumber(-10.0, -10.0));
    }
    @Test
    public void testSubtract(){
        ComplexNumber result = ComplexNumber.subtract(new ComplexNumber(3.0,7.0), new ComplexNumber(-7.0,3.0) );
        assertEquals(result, new ComplexNumber(10.0, 4.0));
        ComplexNumber result2 = ComplexNumber.subtract(new ComplexNumber(3.0,7.0), new ComplexNumber(7.0,3.0) );
        assertEquals(result2, new ComplexNumber(-4.0, 4.0));
        ComplexNumber result3 = ComplexNumber.subtract(new ComplexNumber(3.0,7.0), new ComplexNumber(7.0,-3.0) );
        assertEquals(result3, new ComplexNumber(-4.0, 10.0));
        ComplexNumber result4 = ComplexNumber.subtract(new ComplexNumber(3.0,7.0), new ComplexNumber(-7.0,-3.0) );
        assertEquals(result4, new ComplexNumber(10.0,10.0));

        result = ComplexNumber.subtract(new ComplexNumber(-3.0,7.0), new ComplexNumber(-7.0,3.0) );
        assertEquals(result, new ComplexNumber(4.0, 4.0));
        result2 = ComplexNumber.subtract(new ComplexNumber(-3.0,7.0), new ComplexNumber(7.0,3.0) );
        assertEquals(result2, new ComplexNumber(-10.0, 4.0));
        result3 = ComplexNumber.subtract(new ComplexNumber(-3.0,7.0), new ComplexNumber(7.0,-3.0) );
        assertEquals(result3, new ComplexNumber(-10.0, 10.0));
        result4 = ComplexNumber.subtract(new ComplexNumber(-3.0,7.0), new ComplexNumber(-7.0,-3.0) );
        assertEquals(result4, new ComplexNumber(4.0, 10.0));

        result = ComplexNumber.subtract(new ComplexNumber(3.0,-7.0), new ComplexNumber(-7.0,3.0) );
        assertEquals(result, new ComplexNumber(10.0, -10.0));
        result2 = ComplexNumber.subtract(new ComplexNumber(3.0,-7.0), new ComplexNumber(7.0,3.0) );
        assertEquals(result2, new ComplexNumber(-4.0, -10.0));
        result3 = ComplexNumber.subtract(new ComplexNumber(3.0,-7.0), new ComplexNumber(7.0,-3.0) );
        assertEquals(result3, new ComplexNumber(-4.0, -4.0));
        result4 = ComplexNumber.subtract(new ComplexNumber(3.0,-7.0), new ComplexNumber(-7.0,-3.0) );
        assertEquals(result4, new ComplexNumber(10.0, -4.0));

        result = ComplexNumber.subtract(new ComplexNumber(-3.0,-7.0), new ComplexNumber(-7.0,3.0) );
        assertEquals(result, new ComplexNumber(4.0, -10.0));
        result2 = ComplexNumber.subtract(new ComplexNumber(-3.0,-7.0), new ComplexNumber(7.0,3.0) );
        assertEquals(result2, new ComplexNumber(-10.0, -10.0));
        result3 = ComplexNumber.subtract(new ComplexNumber(-3.0,-7.0), new ComplexNumber(7.0,-3.0) );
        assertEquals(result3, new ComplexNumber(-10.0, -4.0));
        result4 = ComplexNumber.subtract(new ComplexNumber(-3.0,-7.0), new ComplexNumber(-7.0,-3.0) );
        assertEquals(result4, new ComplexNumber(4.0, -4.0));
    }


}
