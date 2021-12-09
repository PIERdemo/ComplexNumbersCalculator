package it.unisa.se.calculator.test;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.structures.ComplexNumberStack;
import it.unisa.se.calculator.model.structures.VariablesMap;
import it.unisa.se.calculator.model.operations.OperationMap;
import it.unisa.se.calculator.model.operations.OperationInvoker;
import it.unisa.se.calculator.model.operations.arithmetic.*;
import it.unisa.se.calculator.model.operations.positional.*;
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
    private VariablesMap variablesMap;


    /**
     * This method starts before @Test methods.
     * Obtains instance of OperationInvoker and ComplexNumberStack
     */
    @Before
    public void setUp() {
        variablesMap =  new VariablesMap();
        operationInvoker = new OperationInvoker(OperationMap.getInstance(variablesMap),null);
        numberStack = ComplexNumberStack.getInstance();
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
        operationInvoker.executeOperation("/");
        assertEquals(numberStack.pop(), new ComplexNumber(1.0, 0.0));

        complexNumber1 = new ComplexNumber(3.0, 9.0);
        complexNumber2 = new ComplexNumber(-3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("/");
        assertEquals(numberStack.pop(), new ComplexNumber(0.8, -0.6));

        complexNumber1 = new ComplexNumber(3.0, 9.0);
        complexNumber2 = new ComplexNumber(-3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, 0.0));

        complexNumber1 = new ComplexNumber(3.0, 9.0);
        complexNumber2 = new ComplexNumber(3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-0.8, 0.6));

        complexNumber1 = new ComplexNumber(-3.0, 9.0);
        complexNumber2 = new ComplexNumber(3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("/");
        assertEquals(numberStack.pop(), new ComplexNumber(0.8, 0.6));

        complexNumber1 = new ComplexNumber(-3.0, 9.0);
        complexNumber2 = new ComplexNumber(-3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("/");
        assertEquals(numberStack.pop(), new ComplexNumber(1.0, 0.0));

        complexNumber1 = new ComplexNumber(-3.0, 9.0);
        complexNumber2 = new ComplexNumber(-3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-0.8, -0.6));

        complexNumber1 = new ComplexNumber(-3.0, 9.0);
        complexNumber2 = new ComplexNumber(3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, 0));

        complexNumber1 = new ComplexNumber(-3.0, -9.0);
        complexNumber2 = new ComplexNumber(3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, 0));

        complexNumber1 = new ComplexNumber(-3.0, -9.0);
        complexNumber2 = new ComplexNumber(-3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-0.8, 0.6));

        complexNumber1 = new ComplexNumber(-3.0, -9.0);
        complexNumber2 = new ComplexNumber(-3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("/");
        assertEquals(numberStack.pop(), new ComplexNumber(1.0, 0));

        complexNumber1 = new ComplexNumber(-3.0, -9.0);
        complexNumber2 = new ComplexNumber(3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("/");
        assertEquals(numberStack.pop(), new ComplexNumber(0.8, -0.6));

        complexNumber1 = new ComplexNumber(3.0, -9.0);
        complexNumber2 = new ComplexNumber(3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-0.8, -0.6));

        complexNumber1 = new ComplexNumber(3.0, -9.0);
        complexNumber2 = new ComplexNumber(-3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("/");
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, 0.0));

        complexNumber1 = new ComplexNumber(3.0, -9.0);
        complexNumber2 = new ComplexNumber(-3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("/");
        assertEquals(numberStack.pop(), new ComplexNumber(0.8, 0.6));

        complexNumber1 = new ComplexNumber(3.0, -9.0);
        complexNumber2 = new ComplexNumber(3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("/");
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
        operationInvoker.executeOperation("*");
        assertEquals(numberStack.pop(), new ComplexNumber(-42.0, -40));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0, 58.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("*");
        assertEquals(numberStack.pop(), new ComplexNumber(42.0, 40.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, -58.0));


        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, -58.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("*");
        assertEquals(numberStack.pop(), new ComplexNumber(-42.0, 40.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, 58.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);

        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("*");
        assertEquals(numberStack.pop(), new ComplexNumber(42.0, -40.0));


        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, 58.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("*");
        assertEquals(numberStack.pop(), new ComplexNumber(42.0, -40.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, -58.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("*");
        assertEquals(numberStack.pop(), new ComplexNumber(-42.0, 40.0));


        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("*");
        assertEquals(numberStack.pop(), new ComplexNumber(42.0, 40.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("*");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, -58.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("*");
        assertEquals(numberStack.pop(), new ComplexNumber(-42.0, -40.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("*");
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
        operationInvoker.executeOperation("+");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 10.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, 10.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, 4.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 4.0));


        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+");
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, 10.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, 10.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, 4.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);

        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+");
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, 4.0));


        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, -4.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, -4.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, -10.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, -10.0));


        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+");
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, -4.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, -4.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, -10.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+");
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
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, -4.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, -4.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, -10.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, -10.0));


        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, -4.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, -4.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, -10.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);

        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, -10.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, 10.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, 10.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, 4.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, 4.0));


        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 10.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, 10.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, 4.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("-");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 4.0));

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
        operationInvoker.executeOperation("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(2.0, 0.0));


        complexNumber1 = new ComplexNumber(0.0, 8.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(2, 2));

        complexNumber1 = new ComplexNumber(0.0, -8.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(2, -2));


        complexNumber1 = new ComplexNumber(-4.0, 0.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, 2.0));

        complexNumber1 = new ComplexNumber(0.0, 0.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(0, 0));

        complexNumber1 = new ComplexNumber(1.0, 13.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(2.649377739244189, 2.453406286207535));

        complexNumber1 = new ComplexNumber(1.0, -13.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(2.649377739244189, -2.453406286207535));

        complexNumber1 = new ComplexNumber(-1.0, -13.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("sqrt");
        assertEquals(numberStack.pop(), new ComplexNumber(2.453406286207535, -2.649377739244189));

        complexNumber1 = new ComplexNumber(-1.0, 13.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("sqrt");
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
        operationInvoker.executeOperation("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 0.0));


        complexNumber1 = new ComplexNumber(0.0, 8.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, -8.0));

        complexNumber1 = new ComplexNumber(0.0, -8.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, 8.0));


        complexNumber1 = new ComplexNumber(-4.0, 0.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, 0.0));

        complexNumber1 = new ComplexNumber(0.0, 0.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(0, 0));

        complexNumber1 = new ComplexNumber(1.0, 13.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, -13.0));

        complexNumber1 = new ComplexNumber(1.0, -13.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, 13.0));

        complexNumber1 = new ComplexNumber(-1.0, -13.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+-");
        assertEquals(numberStack.pop(), new ComplexNumber(1.0, 13.0));

        complexNumber1 = new ComplexNumber(-1.0, 13.0);
        numberStack.push(complexNumber1);
        operationInvoker.executeOperation("+-");
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
        operationInvoker.executeOperation("swap");
        assertEquals(numberStack.pop(), complexNumber1);
        assertEquals(numberStack.pop(), complexNumber2);



        complexNumber1 = new ComplexNumber(3.0, 0);
        complexNumber2 = new ComplexNumber(-7.0, 0.0);
        numberStack.push(complexNumber1);
        numberStack.push(complexNumber2);
        operationInvoker.executeOperation("swap");
        assertEquals(numberStack.pop(), complexNumber1);
        assertEquals(numberStack.pop(), complexNumber2);


        complexNumber1 = new ComplexNumber(0, -7.0);
        complexNumber2 = new ComplexNumber(0, 0);
        numberStack.push(complexNumber1);
        numberStack.push(complexNumber2);
        operationInvoker.executeOperation("swap");
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
        operationInvoker.executeOperation("dup");
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
        operationInvoker.executeOperation("drop");
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
        operationInvoker.executeOperation("clear");
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
        operationInvoker.executeOperation("over");
        assertEquals(numberStack.peek(),new ComplexNumber(10,20));

        numberStack.push(new ComplexNumber(-10,20));
        numberStack.push(new ComplexNumber(-11,21));
        operationInvoker.executeOperation("over");
        assertEquals(numberStack.peek(),new ComplexNumber(-10,20));

        numberStack.push(new ComplexNumber(10,-20));
        numberStack.push(new ComplexNumber(11,-21));
        operationInvoker.executeOperation("over");
        assertEquals(numberStack.peek(),new ComplexNumber(10,-20));

        numberStack.push(new ComplexNumber(-10,-20));
        numberStack.push(new ComplexNumber(-11,-21));
        operationInvoker.executeOperation("over");
        assertEquals(numberStack.peek(),new ComplexNumber(-10,-20));

        numberStack.push(new ComplexNumber(5,0));
        numberStack.push(new ComplexNumber(6,0));
        operationInvoker.executeOperation("over");
        assertEquals(numberStack.peek(),new ComplexNumber(5,0));

        numberStack.push(new ComplexNumber(0,5));
        numberStack.push(new ComplexNumber(0,6));
        operationInvoker.executeOperation("over");
        assertEquals(numberStack.peek(),new ComplexNumber(0,5));

        numberStack.push(new ComplexNumber(0,0));
        numberStack.push(new ComplexNumber(1,2));
        operationInvoker.executeOperation("over");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));
    }

    /**
     * Provides a test capable of checking that execute method of the ModOperation class works correctly.
     * In particular, this method after one insert into the stack and the execution of the operation,
     * tests if the last element of the stack is equals to the module of the inserted number.
     * {@link it.unisa.se.calculator.model.operations.trigonometric.ModOperation}.
     */
    @Test
    public void testModOperation(){
        numberStack.clear();

        numberStack.push(new ComplexNumber(10,0));
        operationInvoker.executeOperation("mod");
        assertEquals(numberStack.peek(),new ComplexNumber(10,0));

        numberStack.push(new ComplexNumber(0,20));
        operationInvoker.executeOperation("mod");
        assertEquals(numberStack.peek(),new ComplexNumber(20,0));

        numberStack.push(new ComplexNumber(3,4));
        operationInvoker.executeOperation("mod");
        assertEquals(numberStack.peek(),new ComplexNumber(5,0));

        numberStack.push(new ComplexNumber(0,0));
        operationInvoker.executeOperation("mod");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));

        numberStack.push(new ComplexNumber(-3,0));
        operationInvoker.executeOperation("mod");
        assertEquals(numberStack.peek(),new ComplexNumber(3,0));

        numberStack.push(new ComplexNumber(0,-3));
        operationInvoker.executeOperation("mod");
        assertEquals(numberStack.peek(),new ComplexNumber(3,0));

        numberStack.push(new ComplexNumber(-3,-4));
        operationInvoker.executeOperation("mod");
        assertEquals(numberStack.peek(),new ComplexNumber(5,0));
    }


    /**
     * Provides a test capable of checking that execute method of the ArgOperation class works correctly.
     * In particular, this method after one insert into the stack and the execution of the operation,
     * tests if the last element of the stack is equals to the argument/phase of the inserted number.
     * {@link it.unisa.se.calculator.model.operations.trigonometric.ArgOperation}.
     */
    @Test
    public void testArgOperation(){
        numberStack.clear();

        numberStack.push(new ComplexNumber(1,1));
        operationInvoker.executeOperation("arg");
        assertEquals(numberStack.peek(),new ComplexNumber(Math.PI/4,0));

        numberStack.push(new ComplexNumber(0,1));
        operationInvoker.executeOperation("arg");
        assertEquals(numberStack.peek(),new ComplexNumber(Math.PI/2,0));

        numberStack.push(new ComplexNumber(1,0));
        operationInvoker.executeOperation("arg");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));

        numberStack.push(new ComplexNumber(2750,0));
        operationInvoker.executeOperation("arg");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));

        numberStack.push(new ComplexNumber(-1,0));
        operationInvoker.executeOperation("arg");
        assertEquals(numberStack.peek(),new ComplexNumber(Math.PI,0));

        numberStack.push(new ComplexNumber(-1,-1));
        operationInvoker.executeOperation("arg");
        assertEquals(numberStack.peek(),new ComplexNumber(Math.PI/4*(-3),0));

        numberStack.push(new ComplexNumber(0,-1));
        operationInvoker.executeOperation("arg");
        assertEquals(numberStack.peek(),new ComplexNumber(-Math.PI/2,0));

        numberStack.push(new ComplexNumber(0,0));
        operationInvoker.executeOperation("arg");
        assertEquals(numberStack.peek(),new ComplexNumber(0,0));
    }

    /**
     * Provides a test capable of checking that execute method of the ExpOperation class works correctly.
     * In particular, this method after one insert into the stack and the execution of the operation,
     * tests if the last element of the stack is equals to the exponential of the inserted number.
     * {@link it.unisa.se.calculator.model.operations.trigonometric.ExpOperation}.
     */
    @Test
    public void testExpOperation(){

        numberStack.push(new ComplexNumber(0,0));
        operationInvoker.executeOperation("exp");
        assertEquals(numberStack.peek(),new ComplexNumber(1,0));

        numberStack.push(new ComplexNumber(1,0));
        operationInvoker.executeOperation("exp");
        assertEquals(numberStack.peek(),new ComplexNumber(Math.E,0));

        numberStack.push(new ComplexNumber(0,Math.PI/2));
        operationInvoker.executeOperation("exp");
        assertEquals(numberStack.peek(),new ComplexNumber(0,1));

        numberStack.push(new ComplexNumber(0,-Math.PI/2));
        operationInvoker.executeOperation("exp");
        assertEquals(numberStack.peek(),new ComplexNumber(0,-1));

        numberStack.push(new ComplexNumber(-1,0));
        operationInvoker.executeOperation("exp");
        assertEquals(numberStack.peek(),new ComplexNumber(1/Math.E,0));

        numberStack.push(new ComplexNumber(-1,-Math.PI/2));
        operationInvoker.executeOperation("exp");
        assertEquals(numberStack.peek(),new ComplexNumber(0,-1/Math.E));
    }

}
