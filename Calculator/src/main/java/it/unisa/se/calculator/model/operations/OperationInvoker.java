package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.exception.NotSupportedOperationException;
import it.unisa.se.calculator.model.VariablesMap;

import java.util.Map;
/**
 * The class has a map that stores as in a dictionary references to objects implementing Operation interface.
 * The class allows the invocation of a particular operation onto the stack data structure .
 *
 * */

public class OperationInvoker {
    private Map<String,Operation> operationMap;

    /**
     * The constructor of the class initialises the data structure with all the operations implemented
     * in the calculator.
     */
    public OperationInvoker(Map<String, Operation> operationMap) {
        this.operationMap = operationMap;
    }

    /**
     * The method checks at first if there exists an operation with the specified name.
     * If it exists then it is executed, on the contrary it is thrown a Runtime Exception.
     *
     * @param stringOperation the string representing the operation inserted and that has to be executed.
     */

    public void execute(String stringOperation){

        Operation operation= operationMap.get(stringOperation);
        if(operation == null)
            throw new NotSupportedOperationException("Operation "+stringOperation+" not found");
        operation.execute();

    }

    /**
     * The method checks at first if there exists an operation with the specified name.
     * If it exists then it is executed, on the contrary it is thrown a Runtime Exception.
     *
     * @param stringOperation the string representing the operation inserted and that has to be executed.
     * @param variablesMap a Map containing all occurrences of previously saved variables
     */
    public void execute(String stringOperation, VariablesMap variablesMap) {

        String variable = "" + stringOperation.charAt(stringOperation.length()-1);

        Operation operation= operationMap.get(stringOperation);
        operation.execute(variablesMap,variable);

    }
}
