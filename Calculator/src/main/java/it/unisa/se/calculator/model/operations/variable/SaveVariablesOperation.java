package it.unisa.se.calculator.model.operations.variable;

import it.unisa.se.calculator.model.VariablesMap;
import it.unisa.se.calculator.model.VariablesMapStack;
import it.unisa.se.calculator.model.operations.Operation;

public class SaveVariablesOperation implements Operation {
    private VariablesMap variablesMap;

    public SaveVariablesOperation(VariablesMap variablesMap) {
        this.variablesMap = variablesMap;
    }

    /**
     * The method executes the load into a memory of a copy of the last variable's values.
     */
    public void execute() {
        VariablesMap clonedVariablesMap = (VariablesMap) variablesMap.clone();
        VariablesMapStack variablesMapStack = VariablesMapStack.getInstance();

        variablesMapStack.push(clonedVariablesMap);

    }
}
