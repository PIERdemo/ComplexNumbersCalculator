package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.exception.NotSupportedOperationException;
import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;

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

    public void resolve(String operationString){
        ComplexNumber complexNumber = ComplexNumber.getComplexNumberFromString(operationString);
        if (complexNumber != null)
            ComplexNumberStack.getInstance().push(complexNumber);
        else
            executeOperation(operationString);
    }



    /**
     * The method checks at first if there exists an operation with the specified name.
     * If it exists then it is executed, on the contrary it is thrown a Runtime Exception.
     *
     * @param operationString the string representing the operation inserted and that has to be executed.
     */
    public void executeOperation(String operationString){
        Operation operation= operationMap.get(operationString);
        if(operation == null)
           executeCustomOperation(operationString);
        operation.execute();

    }

    public void executeCustomOperation(String operationName){
        throw new NotSupportedOperationException("Operation "+operationName+" not found");

    }


}
