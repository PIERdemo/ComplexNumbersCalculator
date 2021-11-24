package it.unisa.se.calculator.test;

import it.unisa.se.calculator.model.Calculator;
import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestCalculator {
    private Calculator calculator;

    @Before
    public void setUp(){
        calculator = new Calculator(ComplexNumberStack.getInstance());
    }

    @Test
    public void testInputDispatcherForNumbers(){
        ComplexNumberStack numberStack=ComplexNumberStack.getInstance();
        numberStack.clear();
        calculator.inputDispatcher("3+3j");
        assertEquals(numberStack.peek(),new ComplexNumber(3,3));
        calculator.inputDispatcher("+3+3j");
        assertEquals(numberStack.peek(),new ComplexNumber(3,3));
        calculator.inputDispatcher("-3+3j");
        assertEquals(numberStack.peek(),new ComplexNumber(-3,3));
        calculator.inputDispatcher("3-3j");
        assertEquals(numberStack.peek(),new ComplexNumber(3,-3));
        calculator.inputDispatcher("+3-3j");
        assertEquals(numberStack.peek(),new ComplexNumber(3,-3));
        calculator.inputDispatcher("-3-3j");
        assertEquals(numberStack.peek(),new ComplexNumber(-3,-3));
        calculator.inputDispatcher("-3");
        assertEquals(numberStack.peek(),new ComplexNumber(-3,0));
        calculator.inputDispatcher("3");
        assertEquals(numberStack.peek(),new ComplexNumber(3,0));
        calculator.inputDispatcher("+3");
        assertEquals(numberStack.peek(),new ComplexNumber(3,0));
        calculator.inputDispatcher("-3j");
        assertEquals(numberStack.peek(),new ComplexNumber(0,-3));
        calculator.inputDispatcher("+3j");
        assertEquals(numberStack.peek(),new ComplexNumber(0,3));
        calculator.inputDispatcher("3j");
        assertEquals(numberStack.peek(),new ComplexNumber(0,3));

        calculator.inputDispatcher("3.2+3.2j");
        assertEquals(numberStack.peek(),new ComplexNumber(3.2,3.2));
        calculator.inputDispatcher("+3.2+3.2j");
        assertEquals(numberStack.peek(),new ComplexNumber(3.2,3.2));
        calculator.inputDispatcher("-3.2+3.2j");
        assertEquals(numberStack.peek(),new ComplexNumber(-3.2,3.2));
        calculator.inputDispatcher("3.2-3.2j");
        assertEquals(numberStack.peek(),new ComplexNumber(3.2,-3.2));
        calculator.inputDispatcher("+3.2-3.2j");
        assertEquals(numberStack.peek(),new ComplexNumber(3.2,-3.2));
        calculator.inputDispatcher("-3.2-3.2j");
        assertEquals(numberStack.peek(),new ComplexNumber(-3.2,-3.2));
        calculator.inputDispatcher("-3.2");
        assertEquals(numberStack.peek(),new ComplexNumber(-3.2,0));
        calculator.inputDispatcher("3.2");
        assertEquals(numberStack.peek(),new ComplexNumber(3.2,0));
        calculator.inputDispatcher("+3.2");
        assertEquals(numberStack.peek(),new ComplexNumber(3.2,0));
        calculator.inputDispatcher("-3.2j");
        assertEquals(numberStack.peek(),new ComplexNumber(0,-3.2));
        calculator.inputDispatcher("+3.2j");
        assertEquals(numberStack.peek(),new ComplexNumber(0,3.2));
        calculator.inputDispatcher("3.2j");
        assertEquals(numberStack.peek(),new ComplexNumber(0,3.2));
    }


}
