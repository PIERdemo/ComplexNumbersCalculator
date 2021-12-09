package it.unisa.se.calculator.test;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.structures.ComplexNumberStack;
import it.unisa.se.calculator.model.structures.VariablesMap;
import it.unisa.se.calculator.model.operations.OperationInvoker;
import it.unisa.se.calculator.model.operations.OperationMap;
import it.unisa.se.calculator.model.operations.variable.DecrementVariableOperation;
import it.unisa.se.calculator.model.operations.variable.IncrementVariableOperation;
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

        complexNumberStack = ComplexNumberStack.getInstance();
        OperationMap operationMap = OperationMap.getInstance(new VariablesMap());
        variablesMap = operationMap.getVariablesMap();
        operationInvoker = new OperationInvoker(operationMap,null);

    }

    /**
     * Provides a test capable of checking that execute method of the IncrementVariableOperation class works correctly.
     * In particular, this method test all the possible cases that can happen in a sum operation between a variable and
     * an element at the top of the stack.
     * {@link IncrementVariableOperation}.
     */
    @Test
    public void testIncrementVariableOperation(){
        complexNumberStack.clear();

        variablesMap.put("a",new ComplexNumber(7,7));
        complexNumberStack.push(new ComplexNumber(3,3));
        //operationInvoker.execute("+a",variablesMap);
        operationInvoker.executeOperation("+a");
        assertEquals(new ComplexNumber(10, 10),variablesMap.get("a"));

        variablesMap.put("c",new ComplexNumber(-7,7));
        complexNumberStack.push(new ComplexNumber(3,-3));
        //operationInvoker.execute("+c",variablesMap);
        operationInvoker.executeOperation("+c");
        assertEquals(variablesMap.get("c"), new ComplexNumber(-4, 4));

        variablesMap.put("q",new ComplexNumber(0,0));
        complexNumberStack.push(new ComplexNumber(0,0));
        //operationInvoker.execute("+q",variablesMap);
        operationInvoker.executeOperation("+q");
        assertEquals(variablesMap.get("q"), new ComplexNumber(0, 0));

        variablesMap.put("z",new ComplexNumber(0,-7));
        complexNumberStack.push(new ComplexNumber(3,-3));
        //operationInvoker.execute("+z",variablesMap);
        operationInvoker.executeOperation("+z");
        assertEquals(variablesMap.get("z"), new ComplexNumber(3, -10));

    }

    /**
     * Provides a test capable of checking that execute method of the IncrementVariableOperation class works correctly.
     * In particular, this method test all the possible cases that can happen in a subtract operation between a variable and
     * an element at the top of the stack.
     * {@link DecrementVariableOperation}.
     */
    @Test
    public void testDecrementVariableOperation(){
        complexNumberStack.clear();

        variablesMap.put("a",new ComplexNumber(7,7));
        complexNumberStack.push(new ComplexNumber(3,3));
       // operationInvoker.execute("-a",variablesMap);
        operationInvoker.executeOperation("-a");
        assertEquals(variablesMap.get("a"), new ComplexNumber(4, 4));

        variablesMap.put("a",new ComplexNumber(-7,7));
        complexNumberStack.push(new ComplexNumber(3,-3));
        //operationInvoker.execute("-a",variablesMap);
        operationInvoker.executeOperation("-a");
        assertEquals(variablesMap.get("a"), new ComplexNumber(-10, 10));

        variablesMap.put("a",new ComplexNumber(0,0));
        complexNumberStack.push(new ComplexNumber(0,0));
        //operationInvoker.execute("-a",variablesMap);
        operationInvoker.executeOperation("-a");
        assertEquals(variablesMap.get("a"), new ComplexNumber(0, 0));

        variablesMap.put("a",new ComplexNumber(0,-7));
        complexNumberStack.push(new ComplexNumber(3,-3));
        //operationInvoker.execute("-a",variablesMap);
        operationInvoker.executeOperation("-a");
        assertEquals(variablesMap.get("a"), new ComplexNumber(-3, -4));

    }


    /**
     * Provides a test capable of checking that execute method of the LoadVariableOperation class works correctly.
     * In particular, this method tests some put operations of variables into the stack
     * {@link it.unisa.se.calculator.model.operations.variable.LoadVariableOperation}.
     */
    @Test
    public void testLoadVariable(){
        complexNumberStack.clear();
        ComplexNumber complexNumber = new ComplexNumber(1,2);
        ComplexNumber complexNumber1 = new ComplexNumber(3,-4);
        variablesMap.put("a",complexNumber);
        //operationInvoker.execute("<a",variablesMap);
        operationInvoker.executeOperation("<a");
        assertEquals(complexNumber, complexNumberStack.peek());

        variablesMap.put("b",complexNumber1);
        //operationInvoker.execute("<b",variablesMap);
        operationInvoker.executeOperation("<b");
        assertEquals(complexNumber1, complexNumberStack.peek());

    }

    /**
     * Provides a test capable of checking that execute method of the SaveVariableOperation class works correctly.
     * In particular, this method tests some push operations of elements of the variables map into the stack
     * {@link it.unisa.se.calculator.model.operations.variable.SaveVariableOperation}.
     */
    @Test
    public void testSaveVariable(){
        complexNumberStack.clear();
        ComplexNumber complexNumber = new ComplexNumber(1,2);
        ComplexNumber complexNumber1 = new ComplexNumber(3,-4);

        complexNumberStack.push(complexNumber);
        //operationInvoker.execute(">a",variablesMap);
        operationInvoker.executeOperation(">a");
        assertEquals(variablesMap.get("a"),complexNumber);

        complexNumberStack.push(complexNumber1);
        //operationInvoker.execute(">b",variablesMap);
        operationInvoker.executeOperation(">b");
        assertEquals(variablesMap.get("b"),complexNumber1);

    }

}
