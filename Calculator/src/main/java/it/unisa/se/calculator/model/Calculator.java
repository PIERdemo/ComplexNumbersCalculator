package it.unisa.se.calculator.model;

import it.unisa.se.calculator.exception.InvalidCustomOperationException;
import it.unisa.se.calculator.model.operations.OperationInvoker;
import it.unisa.se.calculator.model.operations.OperationMap;
import it.unisa.se.calculator.model.structures.ComplexNumberStack;
import it.unisa.se.calculator.model.structures.CustomOperationMap;
import it.unisa.se.calculator.model.structures.VariablesMap;

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

    private final ComplexNumberStack complexNumberStack;
    private final OperationInvoker operationInvoker;
    private final OperationMap operationMap;
    private final VariablesMap variablesMap;
    private final CustomOperationMap customOperationMap;

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

    /**
     * The method allows verifying if the string in input is a custom operation.
     * If the string isn't a custom operation it throws an exception
     * @param customOperationName incoming string that has to be analyzed
     */
    public void customOperationInsertNameValidator(String customOperationName) {
        if (operationMap.containsKey(customOperationName) || customOperationMap.containsKey(customOperationName) ||
            customOperationName.equals("") || ComplexNumber.getComplexNumberFromString(customOperationName) != null)
            throw new InvalidCustomOperationException("The name " + customOperationName + " for the formula is not valid");
    }

    /**
     * The method allows to save a custom operation into a CustomOperationMap
     * @param operationName name of the custom operation
     * @param operationContent list of commands of the custom operation
     */
    public void saveCustomOperation(String operationName, String operationContent) {
        customOperationMap.put(operationName, operationContent);
    }

    /**
     * The method allows to remove a custom operation into a CustomOperationMap
     * @param operationName name of the custom operation
     * @return custom operation removed
     */
    public String removeCustomOperation(String operationName){
       return customOperationMap.remove(operationName);
    }

    /**
     * The method allows getting the instance of the customOperationMap
     * @return instance of customOperationMap
     */
    public CustomOperationMap getCustomOperationMap() {
        return customOperationMap;
    }

    /**
     * The method allows getting the instance of the complexNumberStack
     * @return instance of complexNumberStack
     */
    public ComplexNumberStack getComplexNumberStack() {
        return complexNumberStack;
    }

    /**
     * The method allows getting the instance of the variablesMap
     * @return instance of variablesMap
     */
    public VariablesMap getVariablesMap() {
        return variablesMap;
    }
}
