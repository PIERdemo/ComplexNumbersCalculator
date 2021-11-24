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
    @Test
    public void testMultiply(){
        ComplexNumber result = ComplexNumber.multiply(new ComplexNumber(3.0,7.0), new ComplexNumber(-7.0,3.0) );
        assertEquals(result, new ComplexNumber(-42.0, -40.0));
        ComplexNumber result2 = ComplexNumber.multiply(new ComplexNumber(3.0,7.0), new ComplexNumber(7.0,3.0) );
        assertEquals(result2, new ComplexNumber(0.0, 58.0));
        ComplexNumber result3 = ComplexNumber.multiply(new ComplexNumber(3.0,7.0), new ComplexNumber(7.0,-3.0) );
        assertEquals(result3, new ComplexNumber(42.0, 40.0));
        ComplexNumber result4 = ComplexNumber.multiply(new ComplexNumber(3.0,7.0), new ComplexNumber(-7.0,-3.0) );
        assertEquals(result4, new ComplexNumber(0.0,-58.0));

        result = ComplexNumber.multiply(new ComplexNumber(-3.0,7.0), new ComplexNumber(-7.0,3.0) );
        assertEquals(result, new ComplexNumber(0.0, -58.0));
        result2 = ComplexNumber.multiply(new ComplexNumber(-3.0,7.0), new ComplexNumber(7.0,3.0) );
        assertEquals(result2, new ComplexNumber(-42.0, 40.0));
        result3 = ComplexNumber.multiply(new ComplexNumber(-3.0,7.0), new ComplexNumber(7.0,-3.0) );
        assertEquals(result3, new ComplexNumber(0.0, 58.0));
        result4 = ComplexNumber.multiply(new ComplexNumber(-3.0,7.0), new ComplexNumber(-7.0,-3.0) );
        assertEquals(result4, new ComplexNumber(42.0, -40.0));

        result = ComplexNumber.multiply(new ComplexNumber(3.0,-7.0), new ComplexNumber(-7.0,3.0) );
        assertEquals(result, new ComplexNumber(0.0, 58.0));
        result2 = ComplexNumber.multiply(new ComplexNumber(3.0,-7.0), new ComplexNumber(7.0,3.0) );
        assertEquals(result2, new ComplexNumber(42.0, -40.0));
        result3 = ComplexNumber.multiply(new ComplexNumber(3.0,-7.0), new ComplexNumber(7.0,-3.0) );
        assertEquals(result3, new ComplexNumber(0.0, -58.0));
        result4 = ComplexNumber.multiply(new ComplexNumber(3.0,-7.0), new ComplexNumber(-7.0,-3.0) );
        assertEquals(result4, new ComplexNumber(-42.0, 40.0));

        result = ComplexNumber.multiply(new ComplexNumber(-3.0,-7.0), new ComplexNumber(-7.0,3.0) );
        assertEquals(result, new ComplexNumber(42.0, 40.0));
        result2 = ComplexNumber.multiply(new ComplexNumber(-3.0,-7.0), new ComplexNumber(7.0,3.0) );
        assertEquals(result2, new ComplexNumber(0.0, -58.0));
        result3 = ComplexNumber.multiply(new ComplexNumber(-3.0,-7.0), new ComplexNumber(7.0,-3.0) );
        assertEquals(result3, new ComplexNumber(-42.0, -40.0));
        result4 = ComplexNumber.multiply(new ComplexNumber(-3.0,-7.0), new ComplexNumber(-7.0,-3.0) );
        assertEquals(result4, new ComplexNumber(0.0, 58.0));
    }
    @Test
    public void testDivide(){
        // test all the possible sign occurrences of complex numbers
        ComplexNumber complexNumber1= new ComplexNumber(3.0,9.0);
        ComplexNumber complexNumber2 = new ComplexNumber(3.0,9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(1.0,0.0));

        complexNumber1= new ComplexNumber(3.0,9.0);
        complexNumber2 = new ComplexNumber(-3.0,9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(0.8,-0.6));

        complexNumber1= new ComplexNumber(3.0,9.0);
        complexNumber2 = new ComplexNumber(-3.0,-9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(-1.0,0.0));

        complexNumber1= new ComplexNumber(3.0,9.0);
        complexNumber2 = new ComplexNumber(3.0,-9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(-0.8,0.6));

        complexNumber1= new ComplexNumber(-3.0,9.0);
        complexNumber2 = new ComplexNumber(3.0,9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(0.8,0.6));

        complexNumber1= new ComplexNumber(-3.0,9.0);
        complexNumber2 = new ComplexNumber(-3.0,9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(1.0,0.0));

        complexNumber1= new ComplexNumber(-3.0,9.0);
        complexNumber2 = new ComplexNumber(-3.0,-9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(-0.8,-0.6));

        complexNumber1 = new ComplexNumber(-3.0,9.0);
        complexNumber2 = new ComplexNumber(3.0,-9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(-1.0 , 0));

        complexNumber1= new ComplexNumber(-3.0,-9.0);
        complexNumber2 = new ComplexNumber(3.0,9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(-1.0 , 0));

        complexNumber1= new ComplexNumber(-3.0,-9.0);
        complexNumber2 = new ComplexNumber(-3.0,9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(-0.8 , 0.6));

        complexNumber1= new ComplexNumber(-3.0,-9.0);
        complexNumber2 = new ComplexNumber(-3.0,-9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(1.0 , 0));

        complexNumber1= new ComplexNumber(-3.0,-9.0);
        complexNumber2 = new ComplexNumber(3.0,-9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(0.8 , -0.6));

        complexNumber1= new ComplexNumber(3.0,-9.0);
        complexNumber2 = new ComplexNumber(3.0,9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(-0.8 , -0.6));

        complexNumber1= new ComplexNumber(3.0,-9.0);
        complexNumber2 = new ComplexNumber(-3.0,9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(-1.0 , 0.0));

        complexNumber1= new ComplexNumber(3.0,-9.0);
        complexNumber2 = new ComplexNumber(-3.0,-9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(0.8 , 0.6));

        complexNumber1= new ComplexNumber(3.0,-9.0);
        complexNumber2 = new ComplexNumber(3.0,-9.0);

        assertEquals(ComplexNumber.divide(complexNumber1,complexNumber2), new ComplexNumber(1.0 , 0.0));



    }

}
