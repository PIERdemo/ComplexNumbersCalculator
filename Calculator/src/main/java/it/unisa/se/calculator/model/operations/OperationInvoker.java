package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.exception.NotSupportedOperationException;
import java.util.HashMap;
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
    public OperationInvoker() {
        operationMap = new HashMap<>();
        operationMap.put("+",new SumOperation());
        operationMap.put("-",new SubtractOperation());
        operationMap.put("*",new MultiplyOperation());
        operationMap.put("/",new DivideOperation());
        operationMap.put("+-",new SignInversionOperation());
        operationMap.put("sqrt",new SquareRootOperation());
    }

    /**
     *
     * @param stringOperation the string representing the operation inserted and that has to be executed.
     * The method checks at first if there exists an operation with the specified name.
     * If it exists then it is executed, on the contrary it is thrown a Runtime Exception.
     */

    public void execute(String stringOperation){
        Operation operation = operationMap.get(stringOperation);
        if(operation == null)
            throw new NotSupportedOperationException("Operation "+stringOperation+" not found");
        operation.execute();
    }
}
