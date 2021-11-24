package it.unisa.se.calculator.test;
import static org.junit.Assert.*;

import it.unisa.se.calculator.model.ComplexNumber;
import org.junit.Test;

public class TestComplexNumber {
    @Test
    public void testAdd(){
        ComplexNumber result = ComplexNumber.sum(new ComplexNumber(3.0,7.0), new ComplexNumber(7.0,3.0) );
        assertEquals(result, new ComplexNumber(10.0, 10.0));


    }
}
