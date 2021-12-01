package it.unisa.se.calculator.test;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import it.unisa.se.calculator.model.VariablesMap;
import it.unisa.se.calculator.model.operations.OperationInvoker;
import it.unisa.se.calculator.model.operations.arithmetic.DivideOperation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Test
 * Defines tests to verify the correct functioning of instaces of Operation class
 * {@link it.unisa.se.calculator.model.operations.Operation}
 */

public class TestVariableOperations {
    private VariablesMap variablesMap;
    private ComplexNumberStack complexNumberStack;
    private OperationInvoker operationInvoker;

    /**
     * This method starts before @Test methods.
     * Obtains instance of OperationInvoker, ComplexNumberStack and VariablesMap
     */
    @Before
    public void setUp() {
        variablesMap = new VariablesMap();
        complexNumberStack = ComplexNumberStack.getInstance();
        operationInvoker = new OperationInvoker();

    }

    /**
     * Provides a test capable of checking that execute method of the LoadVariableOperation class works correctly.
     * In particular, this method tests some put operations of variables into the stack
     * {@link it.unisa.se.calculator.model.operations.variable.LoadVariableOperation}.
     */
    @Test
    public void testLoadVariable(){
        ComplexNumber complexNumber = new ComplexNumber(1,2);
        ComplexNumber complexNumber1 = new ComplexNumber(3,-4);
        variablesMap.put("a",complexNumber);
        operationInvoker.execute("<a",variablesMap);
        assertEquals(complexNumber,complexNumberStack.peek());

        variablesMap.put("b",complexNumber1);
        operationInvoker.execute("<b",variablesMap);
        assertEquals(complexNumber1,complexNumberStack.peek());

    }

    /**
     * Provides a test capable of checking that execute method of the SaveVariableOperation class works correctly.
     * In particular, this method tests some push operations of elements of the variables map into the stack
     * {@link it.unisa.se.calculator.model.operations.variable.SaveVariableOperation}.
     */
    @Test
    public void testSaveVariable(){
        ComplexNumber complexNumber = new ComplexNumber(1,2);
        ComplexNumber complexNumber1 = new ComplexNumber(3,-4);

        complexNumberStack.push(complexNumber);
        operationInvoker.execute(">a",variablesMap);
        assertEquals(variablesMap.get("a"),complexNumber);

        complexNumberStack.push(complexNumber1);
        operationInvoker.execute(">b",variablesMap);
        assertEquals(variablesMap.get("b"),complexNumber1);

    }

}
