package it.unisa.se.calculator.model;

import it.unisa.se.calculator.model.operations.Operation;
import it.unisa.se.calculator.model.operations.OperationInvoker;
import it.unisa.se.calculator.model.operations.OperationMap;

import java.util.Map;

/**
 * The class calculator provides an implementation of calculator's logic.
 * It analyses the input and if it is a number, it is saved onto the stack, if it is
 * an operation it is executed, otherwise an error occurs.
 * <p>
 * The class has the stack of complex numbers, which stores the operands,
 * an object OperationInvoker which allows the invocation of operations and
 * a VariablesMap object which allows the creation of a map of variables.
 */
public class Calculator {

    private ComplexNumberStack complexNumberStack;
    private OperationInvoker operationInvoker;
    private Map<String, Operation> operationMap;
    private VariablesMap variablesMap;


    /**
     * The following constructor initialises the variables that will be used
     * to manage and address the values.
     * The class has an instance of complex numbers stack,
     * an object OperationInvoker and a VariablesMap object.
     */
    public Calculator() {
        variablesMap = new VariablesMap();
        operationMap = OperationMap.getInstance(variablesMap);
        complexNumberStack = ComplexNumberStack.getInstance();
        operationInvoker = new OperationInvoker(operationMap);
    }

    /**
     * The method allows verifying if the string in input is a number or an operation.
     * If the string is a number, the method save number is called, otherwise an operation is invoked.
     *
     * @param s incoming string that has to be analyzed
     */
    public void inputDispatcher(String s) {
        ComplexNumber complexNumber = ComplexNumber.getComplexNumberFromString(s);
        if (complexNumber != null)
            complexNumberStack.push(complexNumber);
        else
            operationInvoker.execute(s);

    }
    public void executeCustomOperation(String s){
        for (String s1 : s.split("\\s+"))
            inputDispatcher(s1);
    }

    public ComplexNumberStack getComplexNumberStack() {
        return complexNumberStack;
    }

    public VariablesMap getVariablesMap() {
        return variablesMap;
    }
}
