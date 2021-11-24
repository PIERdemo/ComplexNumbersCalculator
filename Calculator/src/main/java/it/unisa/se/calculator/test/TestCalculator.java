package it.unisa.se.calculator.test;

import it.unisa.se.calculator.model.Calculator;
import it.unisa.se.calculator.model.ComplexNumberStack;
import org.junit.Before;
import org.junit.Test;


public class TestCalculator {
    private Calculator calculator;

    @Before
    public void setUp(){
        calculator = new Calculator(ComplexNumberStack.getInstance());
    }

    @Test
    public void testInputDispatcher(){
        calculator.InputDispatcher("1+3i");
        calculator.InputDispatcher(" 11+11j");
        calculator.InputDispatcher("1-3i");
        calculator.InputDispatcher(" -11j");
        calculator.InputDispatcher("sum");
        calculator.InputDispatcher("1+3a");
        calculator.InputDispatcher("+3");
    }


}
