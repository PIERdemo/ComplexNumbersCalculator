package it.unisa.se.calculator.test;


import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
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
     *
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


}
