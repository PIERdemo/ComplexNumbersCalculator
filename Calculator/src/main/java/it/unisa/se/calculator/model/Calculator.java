package it.unisa.se.calculator.model;

import it.unisa.se.calculator.exception.InvalidCustomOperationException;
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
    private OperationMap operationMap;
    private VariablesMap variablesMap;
    private CustomOperationMap customOperationMap;

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
        customOperationMap = new CustomOperationMap();
        operationInvoker = new OperationInvoker(operationMap,customOperationMap);

    }

    /**
     * The method allows verifying if the string in input is a number or an operation.
     * If the string is a number, the method save number is called, otherwise an operation is invoked.
     *
     * @param inputString incoming string that has to be analyzed
     */
    public void inputDispatcher(String inputString) {
        operationInvoker.resolve(inputString);
    }


    public void customOperationInsertNameValidator(String customOperationName) {
        if (operationMap.containsKey(customOperationName) || customOperationMap.containsKey(customOperationName) ||
            customOperationName.equals("") || ComplexNumber.getComplexNumberFromString(customOperationName) != null)
            throw new InvalidCustomOperationException("The name " + customOperationName + " for the formula is not valid");
    }

    public void saveCustomOperation(String operationName, String operationContent) {
        customOperationMap.put(operationName, operationContent);
    }

    public String removeCustomOperation(String operationName){
       return customOperationMap.remove(operationName);
    }


    public CustomOperationMap getCustomOperationMap() {
        return customOperationMap;
    }

    public ComplexNumberStack getComplexNumberStack() {
        return complexNumberStack;
    }

    public VariablesMap getVariablesMap() {
        return variablesMap;
    }
}
