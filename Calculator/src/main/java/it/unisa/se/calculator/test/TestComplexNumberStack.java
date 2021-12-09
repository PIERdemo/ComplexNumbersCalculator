package it.unisa.se.calculator.test;


import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.structures.ComplexNumberStack;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

/**
 * Test
 * Defines tests to verify the correct functioning of the methods of the ComplexNumberStack class
 * {@link ComplexNumberStack}
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
