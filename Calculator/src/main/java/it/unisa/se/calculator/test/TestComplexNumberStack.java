package it.unisa.se.calculator.test;


import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import org.junit.Before;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.EmptyStackException;
import java.util.List;
import java.util.function.Consumer;

public class TestComplexNumberStack {
    private ComplexNumberStack numberStack;

    @Before
    public void setUp() {
        numberStack = ComplexNumberStack.getInstance();
    }


    @Test
    public void testPop() {
        numberStack.clear();

        numberStack.push(new ComplexNumber(3.0, 3.0));
        assertEquals(numberStack.pop(), new ComplexNumber(3.0, 3.0));

        numberStack.push(new ComplexNumber(3.0, -3.0));
        assertEquals(numberStack.pop(), new ComplexNumber(3.0, -3.0));

        numberStack.push(new ComplexNumber(-3.0, 3.0));
        assertEquals(numberStack.pop(), new ComplexNumber(-3.0, 3.0));

        numberStack.push(new ComplexNumber(-3.0, -3.0));
        assertEquals(numberStack.pop(), new ComplexNumber(-3.0, -3.0));
    }

    @Test(expected = EmptyStackException.class)
    public void testPopWithEmptyStack() {
        numberStack.clear();
        numberStack.pop();
    }

    @Test
    public void testPush() {
        numberStack.clear();
        numberStack.push(new ComplexNumber(5.0, 5.0));
        assertEquals(numberStack.peek(), new ComplexNumber(5.0, 5.0));

        numberStack.push(new ComplexNumber(-5.0, 5.0));
        assertEquals(numberStack.peek(), new ComplexNumber(-5.0, 5.0));

        numberStack.push(new ComplexNumber(5.0, -5.0));
        assertEquals(numberStack.peek(), new ComplexNumber(5.0, -5.0));

        numberStack.push(new ComplexNumber(-5.0, -5.0));
        assertEquals(numberStack.peek(), new ComplexNumber(-5.0, -5.0));

    }


    @Test
    public void testTop() {
        numberStack.clear();
        for (int i = 0; i < 10; i++)
            numberStack.push(new ComplexNumber(i + 1, i + 1));
        assertEquals(numberStack.peek(), new ComplexNumber(10.0, 10.0));

        for (int i = 0; i < 10; i++)
            numberStack.push(new ComplexNumber(i + 1, -(i + 1)));
        assertEquals(numberStack.peek(), new ComplexNumber(10.0, -10.0));

        for (int i = 0; i < 10; i++)
            numberStack.push(new ComplexNumber(-(i + 1), i + 1));
        assertEquals(numberStack.peek(), new ComplexNumber(-10.0, 10.0));

        for (int i = 0; i < 10; i++)
            numberStack.push(new ComplexNumber(-(i + 1), -(i + 1)));
        assertEquals(numberStack.peek(), new ComplexNumber(-10.0, -10.0));

    }

    @Test(expected = EmptyStackException.class)
    public void testTopWithEmptyStack() {
        numberStack.clear();
        numberStack.peek();
    }

    @Test
    public void testTopKElements() {
        numberStack.clear();
        for (int i = 0; i < 10; i++)
            numberStack.push(new ComplexNumber(i + 1, i + 1));

        int k = 5;
        List<ComplexNumber> topKElements = numberStack.topKElements(k);
        for (int i = 0; i < topKElements.size(); i++) {
            assertEquals(topKElements.get(i), new ComplexNumber(i + 1 + k, i + 1 + k));
        }

        //test with empty stack
        numberStack.clear();
        topKElements = numberStack.topKElements(k);
        assertEquals(topKElements.size(), 0);


        //test with few values than required
        for (int i = 0; i < 2; i++)
            numberStack.push(new ComplexNumber(i + 1, i + 1));

        topKElements = numberStack.topKElements(k);
        for (int i = 0; i < topKElements.size(); i++) {
            assertEquals(topKElements.get(i), new ComplexNumber(i + 1, i + 1));
        }
    }


    @Test
    public void testDivide() {
        // test all the possible sign occurrences of complex numbers
        numberStack.clear();
        ComplexNumber complexNumber1 = new ComplexNumber(3.0, 9.0);
        ComplexNumber complexNumber2 = new ComplexNumber(3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
        assertEquals(numberStack.pop(), new ComplexNumber(1.0, 0.0));

        complexNumber1 = new ComplexNumber(3.0, 9.0);
        complexNumber2 = new ComplexNumber(-3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
        assertEquals(numberStack.pop(), new ComplexNumber(0.8, -0.6));

        complexNumber1 = new ComplexNumber(3.0, 9.0);
        complexNumber2 = new ComplexNumber(-3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, 0.0));

        complexNumber1 = new ComplexNumber(3.0, 9.0);
        complexNumber2 = new ComplexNumber(3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
        assertEquals(numberStack.pop(), new ComplexNumber(-0.8, 0.6));

        complexNumber1 = new ComplexNumber(-3.0, 9.0);
        complexNumber2 = new ComplexNumber(3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
        assertEquals(numberStack.pop(), new ComplexNumber(0.8, 0.6));

        complexNumber1 = new ComplexNumber(-3.0, 9.0);
        complexNumber2 = new ComplexNumber(-3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
        assertEquals(numberStack.pop(), new ComplexNumber(1.0, 0.0));

        complexNumber1 = new ComplexNumber(-3.0, 9.0);
        complexNumber2 = new ComplexNumber(-3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
        assertEquals(numberStack.pop(), new ComplexNumber(-0.8, -0.6));

        complexNumber1 = new ComplexNumber(-3.0, 9.0);
        complexNumber2 = new ComplexNumber(3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, 0));

        complexNumber1 = new ComplexNumber(-3.0, -9.0);
        complexNumber2 = new ComplexNumber(3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, 0));

        complexNumber1 = new ComplexNumber(-3.0, -9.0);
        complexNumber2 = new ComplexNumber(-3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
        assertEquals(numberStack.pop(), new ComplexNumber(-0.8, 0.6));

        complexNumber1 = new ComplexNumber(-3.0, -9.0);
        complexNumber2 = new ComplexNumber(-3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
        assertEquals(numberStack.pop(), new ComplexNumber(1.0, 0));

        complexNumber1 = new ComplexNumber(-3.0, -9.0);
        complexNumber2 = new ComplexNumber(3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
        assertEquals(numberStack.pop(), new ComplexNumber(0.8, -0.6));

        complexNumber1 = new ComplexNumber(3.0, -9.0);
        complexNumber2 = new ComplexNumber(3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
        assertEquals(numberStack.pop(), new ComplexNumber(-0.8, -0.6));

        complexNumber1 = new ComplexNumber(3.0, -9.0);
        complexNumber2 = new ComplexNumber(-3.0, 9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
        assertEquals(numberStack.pop(), new ComplexNumber(-1.0, 0.0));

        complexNumber1 = new ComplexNumber(3.0, -9.0);
        complexNumber2 = new ComplexNumber(-3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
        assertEquals(numberStack.pop(), new ComplexNumber(0.8, 0.6));

        complexNumber1 = new ComplexNumber(3.0, -9.0);
        complexNumber2 = new ComplexNumber(3.0, -9.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.divide();
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
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(-42.0, -40));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(0, 58.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(42.0, 40.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, -58.0));


        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, -58.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(-42.0, 40.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, 58.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);

        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(42.0, -40.0));


        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, 58.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(42.0, -40.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, -58.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(-42.0, 40.0));


        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(42.0, 40.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, -58.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(-42.0, -40.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.multiply();
        assertEquals(numberStack.pop(), new ComplexNumber(0.0, 58.0));

    }

    @Test
    public void testSum() {


        numberStack.clear();
        ComplexNumber complexNumber1 = new ComplexNumber(3.0, 7.0);
        ComplexNumber complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 10.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, 10.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, 4.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 4.0));


        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, 10.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, 10.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, 4.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);

        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, 4.0));


        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, -4.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, -4.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, -10.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, -10.0));


        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, -4.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, -4.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, -10.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.sum();
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, -10.0));

    }

    @Test
    public void testSubtract() {


        numberStack.clear();
        ComplexNumber complexNumber1 = new ComplexNumber(3.0, 7.0);
        ComplexNumber complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, 4.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 4.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, 10.0));

        complexNumber1 = new ComplexNumber(3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, 10.0));


        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, 4.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, 4.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, 10.0));

        complexNumber1 = new ComplexNumber(-3.0, 7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);

        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, 10.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, -10.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, -10.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(-4.0, -4.0));

        complexNumber1 = new ComplexNumber(3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(10.0, -4.0));


        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, -10.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, 3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, -10.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(-10.0, -4.0));

        complexNumber1 = new ComplexNumber(-3.0, -7.0);
        complexNumber2 = new ComplexNumber(-7.0, -3.0);
        numberStack.push(complexNumber2);
        numberStack.push(complexNumber1);
        numberStack.subtract();
        assertEquals(numberStack.pop(), new ComplexNumber(4.0, -4.0));

    }

    @Test
    public void testSquareRoot(){
        numberStack.clear();
        ComplexNumber complexNumber1 = new ComplexNumber(4.0, 0.0);
        numberStack.push(complexNumber1);
        numberStack.squareRoot();
        assertEquals(numberStack.pop(), new ComplexNumber(2.0,0.0));


        complexNumber1 = new ComplexNumber(0.0, 8.0);
        numberStack.push(complexNumber1);
        numberStack.squareRoot();
        assertEquals(numberStack.pop(), new ComplexNumber(2,2));

        complexNumber1 = new ComplexNumber( 0.0, -8.0);
        numberStack.push(complexNumber1);
        numberStack.squareRoot();
        assertEquals(numberStack.pop(), new ComplexNumber(2,-2));


        complexNumber1 = new ComplexNumber(-4.0, 0.0);
        numberStack.push(complexNumber1);
        numberStack.squareRoot();
        assertEquals(numberStack.pop(), new ComplexNumber(0.0,2.0));

        complexNumber1 = new ComplexNumber(0.0, 0.0);
        numberStack.push(complexNumber1);
        numberStack.squareRoot();
        assertEquals(numberStack.pop(), new ComplexNumber(0,0));

        complexNumber1 = new ComplexNumber(1.0, 13.0);
        numberStack.push(complexNumber1);
        numberStack.squareRoot();
        assertEquals(numberStack.pop(), new ComplexNumber(2.649377739244189,2.453406286207535));

        complexNumber1 = new ComplexNumber(1.0, -13.0);
        numberStack.push(complexNumber1);
        numberStack.squareRoot();
        assertEquals(numberStack.pop(), new ComplexNumber(2.649377739244189,-2.453406286207535));

        complexNumber1 = new ComplexNumber(-1.0, -13.0);
        numberStack.push(complexNumber1);
        numberStack.squareRoot();
        assertEquals(numberStack.pop(), new ComplexNumber(2.453406286207535,-2.649377739244189));

        complexNumber1 = new ComplexNumber(-1.0, 13.0);
        numberStack.push(complexNumber1);
        numberStack.squareRoot();
        assertEquals(numberStack.pop(), new ComplexNumber(2.453406286207535,2.649377739244189));


    }

}
