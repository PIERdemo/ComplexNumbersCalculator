package it.unisa.se.calculator.test;

import it.unisa.se.calculator.exception.NotSupportedOperationException;
import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import it.unisa.se.calculator.model.operations.OperationInvoker;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;


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
     * {@link it.unisa.se.calculator.model.operations.DivideOperation}.
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
     * {@link it.unisa.se.calculator.model.operations.MultiplyOperation}.
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
     * {@link it.unisa.se.calculator.model.operations.SumOperation}.
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
     * {@link it.unisa.se.calculator.model.operations.SubtractOperation}.
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
     * {@link it.unisa.se.calculator.model.operations.SquareRootOperation}.
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
     * {@link it.unisa.se.calculator.model.operations.SignInversionOperation}.
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





}
