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
        calculator = new Calculator();
        numberStack =ComplexNumberStack.getInstance();
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

        calculator.inputDispatcher("0j");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));
        calculator.inputDispatcher("-0j");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));
        calculator.inputDispatcher("+0j");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));
        calculator.inputDispatcher("0");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));
        calculator.inputDispatcher("-0");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));
        calculator.inputDispatcher("+0");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));
        calculator.inputDispatcher("0+0j");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));
        calculator.inputDispatcher("0-0j");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));
        calculator.inputDispatcher("+0-0j");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));
        calculator.inputDispatcher("-0-0j");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));
    }

    @Test
    public void testInputDispatcherForOperations(){
        numberStack.clear();

        numberStack.push(new ComplexNumber(3.0, 7.0));
        numberStack.push(new ComplexNumber(7.0, 3.0));
        calculator.inputDispatcher("+");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, 10.0));

        numberStack.push(new ComplexNumber(3.0, 7.0));
        numberStack.push(new ComplexNumber(7.0, 3.0));
        calculator.inputDispatcher("-");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, -4.0));


        numberStack.push(new ComplexNumber(3.0, 7.0));
        numberStack.push(new ComplexNumber(7.0, 3.0));
        calculator.inputDispatcher("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0, 58.0));

        numberStack.push(new ComplexNumber(3.0, -9.0));
        numberStack.push(new ComplexNumber(3.0, 9.0));
        calculator.inputDispatcher("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-0.8, 0.6));


        numberStack.push(new ComplexNumber(4.0, 0.0));
        calculator.inputDispatcher("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(2.0, 0.0));

        numberStack.push(new ComplexNumber(4.0, 0.0));
        calculator.inputDispatcher("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 0.0));

    }


}
