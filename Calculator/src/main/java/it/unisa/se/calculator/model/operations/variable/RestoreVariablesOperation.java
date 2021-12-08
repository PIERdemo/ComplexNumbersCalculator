package it.unisa.se.calculator.model.operations.variable;

import it.unisa.se.calculator.model.VariablesMap;
import it.unisa.se.calculator.model.VariablesMapStack;
import it.unisa.se.calculator.model.operations.Operation;

public class RestoreVariablesOperation implements Operation {
    private VariablesMap variablesMap;

    public RestoreVariablesOperation(VariablesMap variablesMap) {
        this.variablesMap = variablesMap;
    }
    @Override
    public void execute() {
        VariablesMapStack variablesMapStack = VariablesMapStack.getInstance();
        variablesMap.clear();
        variablesMap.putAll(variablesMapStack.pop());
    }


}
