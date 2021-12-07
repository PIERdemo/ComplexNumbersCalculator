package it.unisa.se.calculator.model.operations.variable;

import it.unisa.se.calculator.model.VariablesMap;
import it.unisa.se.calculator.model.operations.Operation;

public class RestoreVariablesOperation extends Operation {
    private VariablesMap variablesMap;

    public RestoreVariablesOperation(VariablesMap variablesMap) {
        this.variablesMap = variablesMap;
    }
    @Override
    public void execute() {
        variablesMap.clear();
        variablesMap.putAll(new VariablesMap());
    }


}
