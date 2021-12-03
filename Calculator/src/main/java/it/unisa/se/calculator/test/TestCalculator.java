package it.unisa.se.calculator.test;

import it.unisa.se.calculator.model.Calculator;
import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test
 * Defines tests to verify the correct functioning of the methods of the Calculator class
 * {@link it.unisa.se.calculator.model.Calculator}
 */
public class TestCalculator {
    private Calculator calculator;
    private ComplexNumberStack numberStack;

    /**
     * This method starts before @Test methods.
     * Obtains instances of Calculator and ComplexNumberStack
     */
    @Before
    public void setUp(){
        calculator = new Calculator();
        numberStack = ComplexNumberStack.getInstance();
    }

    /**
     * Provides a test capable of checking that the numbers, in particular {@link it.unisa.se.calculator.model.ComplexNumber},
     * are entered correctly of the InputDispatcher method.
     * The assertEquals method is used {@link org.junit.Assert}.
     */
    @Test
    public void testInputDispatcherForNumbers(){

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

    /**
     * Provides a test capable of checking that the operations are entered correctly of the InputDispatcher method.
     * The assertEquals method is used {@link org.junit.Assert}.
     */
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
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 4.0));


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
