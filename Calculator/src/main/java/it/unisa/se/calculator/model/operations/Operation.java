package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.exception.NotSupportedOperationException;
import it.unisa.se.calculator.model.VariablesMap;

/**
 * The class is an interface that provides a method execute to execute a particular operation.
 * */
public abstract class Operation {
    public void execute(){
        throw new NotSupportedOperationException("This operation is not supported yet");
    }

   public void execute(VariablesMap variablesMap,String variable){
        throw new NotSupportedOperationException("This operation is not supported yet");
    }


}
