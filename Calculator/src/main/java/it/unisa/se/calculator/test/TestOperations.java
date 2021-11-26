package it.unisa.se.calculator.test;

import it.unisa.se.calculator.exception.NotSupportedOperationException;
import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import it.unisa.se.calculator.model.operations.OperationInvoker;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TestOperations {
    private OperationInvoker operationInvoker;
    private ComplexNumberStack numberStack;

    @Before
    public void setUp() {
        operationInvoker = new OperationInvoker();
        numberStack = ComplexNumberStack.getInstance();
    }

    @Test(expected = NotSupportedOperationException.class)
    public void testOperationNotFound() {
        operationInvoker.execute("^");
    }


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
