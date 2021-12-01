package it.unisa.se.calculator.test;

import it.unisa.se.calculator.exception.NotSupportedOperationException;
import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import it.unisa.se.calculator.model.operations.OperationInvoker;
import it.unisa.se.calculator.model.operations.arithmetic.*;
import it.unisa.se.calculator.model.operations.stack.*;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Test
 * Defines tests to verify the correct functioning of instaces of Operation interface
 * {@link it.unisa.se.calculator.model.operations.Operation}
 */

public class TestOperations {
    private OperationInvoker operationInvoker;
    private ComplexNumberStack numberStack;


    /**
     * This method starts before @Test methods.
     * Obtains instance of OperationInvoker and ComplexNumberStack
     */
    @Before
    public void setUp() {
        operationInvoker = new OperationInvoker();
        numberStack = ComplexNumberStack.getInstance();
    }


    /**
     * This method starts before @Test methods.
     * Obtains instance of OperationInvoker and ComplexNumberStack
     */
    @Test(expected = NotSupportedOperationException.class)
    public void testOperationNotFound() {
        operationInvoker.execute("^");
    }


    /**
     * Provides a test capable of checking that execute method of the DivideOperation class works correctly.
     * In particular, this method test all the possible sign occurrences of complex numbers used in divide operation.
     * {@link DivideOperation}.
     */
    @Test
    public void testDivide() {
        // test all the possible sign occurrences of complex numbers
        numberStack.clear();
        ComplexNumber complexNumber1 = new ComplexNumber(3.0, 9.0);
        ComplexNumber complexNumber2 = new ComplexNumber(3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(1.0, 0.0));

        complexNumber1 = new ComplexNumber(3.0, 9.0);
        complexNumber2 = new ComplexNumber(-3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(0.8, -0.6));

        complexNumber1 = new ComplexNumber(3.0, 9.0);
        complexNumber2 = new ComplexNumber(-3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, 0.0));

        complexNumber1 = new ComplexNumber(3.0, 9.0);
        complexNumber2 = new ComplexNumber(3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-0.8, 0.6));

        complexNumber1 = new ComplexNumber(-3.0, 9.0);
        complexNumber2 = new ComplexNumber(3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(0.8, 0.6));

        complexNumber1 = new ComplexNumber(-3.0, 9.0);
        complexNumber2 = new ComplexNumber(-3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(1.0, 0.0));

        complexNumber1 = new ComplexNumber(-3.0, 9.0);
        complexNumber2 = new ComplexNumber(-3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-0.8, -0.6));

        complexNumber1 = new ComplexNumber(-3.0, 9.0);
        complexNumber2 = new ComplexNumber(3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, 0));

        complexNumber1 = new ComplexNumber(-3.0, -9.0);
        complexNumber2 = new ComplexNumber(3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, 0));

        complexNumber1 = new ComplexNumber(-3.0, -9.0);
        complexNumber2 = new ComplexNumber(-3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-0.8, 0.6));

        complexNumber1 = new ComplexNumber(-3.0, -9.0);
        complexNumber2 = new ComplexNumber(-3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(1.0, 0));

        complexNumber1 = new ComplexNumber(-3.0, -9.0);
        complexNumber2 = new ComplexNumber(3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(0.8, -0.6));

        complexNumber1 = new ComplexNumber(3.0, -9.0);
        complexNumber2 = new ComplexNumber(3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-0.8, -0.6));

        complexNumber1 = new ComplexNumber(3.0, -9.0);
        complexNumber2 = new ComplexNumber(-3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, 0.0));

        complexNumber1 = new ComplexNumber(3.0, -9.0);
        complexNumber2 = new ComplexNumber(-3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(0.8, 0.6));

        complexNumber1 = new ComplexNumber(3.0, -9.0);
        complexNumber2 = new ComplexNumber(3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("/");
        assertEquals(numberStack.pop(), new ComplexNumber(1.0, 0.0));


    }


    /**
     * Provides a test capable of checking that execute method of the MultiplyOperation class works correctly.
     * In particular, this method test all the possible sign occurrences of complex numbers used in multiply operation.
     * {@link MultiplyOperation}.
     */
    @Test
    public void testMultiply() {
        // test all the possible sign occurrences of complex numbers
        numberStack.clear();
        ComplexNumber complexNumber1 = new ComplexNumber(3.0, 7.0);
        ComplexNumber complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(-42.0, -40));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0, 58.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(42.0, 40.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, -58.0));


        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, -58.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(-42.0, 40.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, 58.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);

        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(42.0, -40.0));


        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, 58.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(42.0, -40.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, -58.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(-42.0, 40.0));


        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(42.0, 40.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, -58.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(-42.0, -40.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, 58.0));

    }

    /**
     * Provides a test capable of checking that execute method of the SumOperation class works correctly.
     * In particular, this method test all the possible sign occurrences of complex numbers used in sum operation.
     * {@link SumOperation}.
     */
    @Test
    public void testSum() {
        numberStack.clear();
        ComplexNumber complexNumber1 = new ComplexNumber(3.0, 7.0);
        ComplexNumber complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 10.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, 10.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, 4.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 4.0));


        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, 10.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, 10.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, 4.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);

        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, 4.0));


        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, -4.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, -4.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, -10.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, -10.0));


        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, -4.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, -4.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, -10.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+");
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, -10.0));

    }


    /**
     * Provides a test capable of checking that execute method of the SubtractOperation class works correctly.
     * In particular, this method test all the possible sign occurrences of complex numbers used in subtract operation.
     * {@link SubtractOperation}.
     */
    @Test
    public void testSubtract() {


        numberStack.clear();
        ComplexNumber complexNumber1 = new ComplexNumber(3.0, 7.0);
        ComplexNumber complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, 4.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 4.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 10.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, 10.0));


        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, 4.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, 4.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, 10.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);

        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, 10.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, -10.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, -10.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, -4.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, -4.0));


        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, -10.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, -10.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, -4.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.execute("-");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, -4.0));

    }


    /**
     * Provides a test capable of checking that execute method of the SquareRootOperation class works correctly.
     * In particular, this method test all the possible sign occurrences of complex numbers used in square root operation.
     * {@link SquareRootOperation}.
     */
    @Test
    public void testSquareRoot() {
        numberStack.clear();
        ComplexNumber complexNumber1 = new ComplexNumber(4.0, 0.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(2.0, 0.0));


        complexNumber1 = new ComplexNumber(0.0, 8.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(2, 2));

        complexNumber1 = new ComplexNumber(0.0, -8.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(2, -2));


        complexNumber1 = new ComplexNumber(-4.0, 0.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, 2.0));

        complexNumber1 = new ComplexNumber(0.0, 0.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(0, 0));

        complexNumber1 = new ComplexNumber(1.0, 13.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(2.649377739244189, 2.453406286207535));

        complexNumber1 = new ComplexNumber(1.0, -13.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(2.649377739244189, -2.453406286207535));

        complexNumber1 = new ComplexNumber(-1.0, -13.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(2.453406286207535, -2.649377739244189));

        complexNumber1 = new ComplexNumber(-1.0, 13.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(2.453406286207535, 2.649377739244189));


    }

    /**
     * Provides a test capable of checking that execute method of the SignInversionOperation class works correctly.
     * In particular, this method test all the possible sign occurrences of complex numbers used in sign inversion operation.
     * {@link SignInversionOperation}.
     */
    @Test
    public void testSignInversion() {
        numberStack.clear();
        ComplexNumber complexNumber1 = new ComplexNumber(4.0, 0.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 0.0));


        complexNumber1 = new ComplexNumber(0.0, 8.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, -8.0));

        complexNumber1 = new ComplexNumber(0.0, -8.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, 8.0));


        complexNumber1 = new ComplexNumber(-4.0, 0.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, 0.0));

        complexNumber1 = new ComplexNumber(0.0, 0.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(0, 0));

        complexNumber1 = new ComplexNumber(1.0, 13.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, -13.0));

        complexNumber1 = new ComplexNumber(1.0, -13.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, 13.0));

        complexNumber1 = new ComplexNumber(-1.0, -13.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(1.0, 13.0));

        complexNumber1 = new ComplexNumber(-1.0, 13.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(1.0, -13.0));

    }

    /**
     * Provides a test capable of checking that execute method of the SwapOperation class works correctly.
     * In particular, this method test all the possible cases of complex numbers used in swap operation.
     * {@link SwapOperation}.
     */
    @Test
    public void testSwap() {
        numberStack.clear();

        ComplexNumber complexNumber1 = new ComplexNumber(3.0, -7.0);
        ComplexNumber complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber1);
        numberStack.push(complexNumber2);
        operationInvoker.execute("swap");
        assertEquals(numberStack.pop(), complexNumber1);
        assertEquals(numberStack.pop(), complexNumber2);



        complexNumber1 = new ComplexNumber(3.0, 0);
        complexNumber2 = new ComplexNumber(-7.0, 0.0);
        numberStack.push(complexNumber1);
        numberStack.push(complexNumber2);
        operationInvoker.execute("swap");
        assertEquals(numberStack.pop(), complexNumber1);
        assertEquals(numberStack.pop(), complexNumber2);


        complexNumber1 = new ComplexNumber(0, -7.0);
        complexNumber2 = new ComplexNumber(0, 0);
        numberStack.push(complexNumber1);
        numberStack.push(complexNumber2);
        operationInvoker.execute("swap");
        assertEquals(numberStack.pop(), complexNumber1);
        assertEquals(numberStack.pop(), complexNumber2);

    }
    /**
     * Provides a test capable of checking that execute method of the DupOperation class works correctly.
     * {@link DupOperation}.
     */
    @Test
    public void testDup() {
        numberStack.clear();
        ComplexNumber complexNumber1 = new ComplexNumber(4.0, 0.0);
        numberStack.push(complexNumber1);
        operationInvoker.execute("dup");
        assertEquals(numberStack.elementAt(numberStack.size() - 2), numberStack.elementAt(numberStack.size()-1));

    }

    /**
     * Provides a test capable of checking that execute method of the DropOperation class works correctly.
     * In particular, this method test all the possible cases of complex numbers used in drop operation.
     * {@link DropOperation}.
     */

    @Test
    public void testDrop() {
        numberStack.clear();

        ComplexNumber complexNumber1 = new ComplexNumber(3.0, -7.0);
        ComplexNumber complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber1);
        numberStack.push(complexNumber2);
        operationInvoker.execute("drop");
        assertEquals(numberStack.pop(), complexNumber1);

    }

    /**
     * Provides a test capable of checking that execute method of the ClearOperation class works correctly.
     * In particular, this method after a couple of heterogeneous insert into the stack and  the clear operation, tests is the stack is empty .
     * {@link ClearOperation}.
     */
    @Test
    public void testClear(){
        numberStack.clear();
        for(int i=0; i<5;i++)
            numberStack.push(new ComplexNumber(i,i));
        for(int i=0; i<5;i++)
            numberStack.push(new ComplexNumber(-i,i));
        for(int i=0; i<5;i++)
            numberStack.push(new ComplexNumber(i,-i));
        for(int i=0; i<5;i++)
            numberStack.push(new ComplexNumber(-i,-i));
        operationInvoker.execute("clear");
        assertTrue(numberStack.isEmpty());

    }
    /**
     * Provides a test capable of checking that execute method of the OverOperation class works correctly.
     * In particular, this method after two insert into the stack, after the operation tests if the third to last element is
     * equals to the top of the stack.
     * {@link OverOperation}.
     */

    @Test
    public void testOver(){
        numberStack.clear();
        numberStack.push(new ComplexNumber(10,20));
        numberStack.push(new ComplexNumber(11,21));
        operationInvoker.execute("over");
        assertEquals(numberStack.peek(),new ComplexNumber(10,20));

        numberStack.push(new ComplexNumber(-10,20));
        numberStack.push(new ComplexNumber(-11,21));
        operationInvoker.execute("over");
        assertEquals(numberStack.peek(),new ComplexNumber(-10,20));

        numberStack.push(new ComplexNumber(10,-20));
        numberStack.push(new ComplexNumber(11,-21));
        operationInvoker.execute("over");
        assertEquals(numberStack.peek(),new ComplexNumber(10,-20));

        numberStack.push(new ComplexNumber(-10,-20));
        numberStack.push(new ComplexNumber(-11,-21));
        operationInvoker.execute("over");
        assertEquals(numberStack.peek(),new ComplexNumber(-10,-20));

        numberStack.push(new ComplexNumber(5,0));
        numberStack.push(new ComplexNumber(6,0));
        operationInvoker.execute("over");
        assertEquals(numberStack.peek(),new ComplexNumber(5,0));

        numberStack.push(new ComplexNumber(0,5));
        numberStack.push(new ComplexNumber(0,6));
        operationInvoker.execute("over");
        assertEquals(numberStack.peek(),new ComplexNumber(0,5));

        numberStack.push(new ComplexNumber(0,0));
        numberStack.push(new ComplexNumber(1,2));
        operationInvoker.execute("over");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));
    }


}
