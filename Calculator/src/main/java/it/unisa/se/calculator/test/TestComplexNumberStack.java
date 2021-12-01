package it.unisa.se.calculator.test;


import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import org.junit.Before;

import static org.junit.Assert.*;

import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Test
 * Defines tests to verify the correct functioning of the methods of the ComplexNumberStack class
 * {@link it.unisa.se.calculator.model.ComplexNumberStack}
 */
public class TestComplexNumberStack {
    private ComplexNumberStack numberStack;


    /**
     * This method starts before @Test methods.
     * Obtains instance of ComplexNumberStack
     */
    @Before
    public void setUp() {
        numberStack = ComplexNumberStack.getInstance();
    }


    /**
     * This method tests the TopKElements of class ComplexNumberStack.
     * Particularly, insert some elements on the stack and compare the list
     * returned by the topKElement method with the top k elements of the stack
     */
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


    /**
     * This method tests the GetOperand of class ComplexNumberStack.
     * Particularly, insert some elements on the stack and compare the list
     * returned by the topKElement method with the elements of the stack.
     *
     */
    @Test
    public void testGetOperand() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        complexNumberStack.clear();
        for (int i = 0; i < 10; i++) {
            complexNumberStack.push(new ComplexNumber(i + 1, i + 2));
        }
        Iterator<ComplexNumber> operands = complexNumberStack.getOperand(10);
        for (int i = 9; i >= 0; i--) {
            assertEquals(operands.next(), new ComplexNumber(i + 1, i + 2));
        }
        assertEquals(complexNumberStack.size(), 0);


    }

    /**
     * This method tests the GetOperand of class ComplexNumberStack.
     * Particularly, it throws an InvalidParameterException because the stack is empty
     *
     */
    @Test(expected = InvalidParameterException.class)
    public void testGetOperandWithException() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        complexNumberStack.clear();
        Iterator<ComplexNumber> operands2 = complexNumberStack.getOperand(1);

    }


}
