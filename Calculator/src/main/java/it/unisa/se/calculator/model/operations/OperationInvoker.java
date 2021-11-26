package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.exception.NotSupportedOperationException;

import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.Map;


public class OperationInvoker {
    private Map<String,Operation> operationMap;

    public OperationInvoker() {
        operationMap = new HashMap<>();
        operationMap.put("+",new SumOperation());
        operationMap.put("-",new SubtractOperation());
        operationMap.put("*",new MultiplyOperation());
        operationMap.put("/",new DivideOperation());
        operationMap.put("+-",new SignInversionOperation());
        operationMap.put("sqrt",new SquareRootOperation());
    }

    public void execute(String stringOperation){
        Operation operation = operationMap.get(stringOperation);
        if(operation == null)
            throw new NotSupportedOperationException("Operation "+stringOperation+" not found");
        operation.execute();
    }
}
