package it.unisa.se.calculator.model.operations.variable;

import it.unisa.se.calculator.model.VariablesMap;
import it.unisa.se.calculator.model.operations.Operation;

public class SaveVariablesOperation extends Operation {
    private VariablesMap variablesMap;

    public SaveVariablesOperation(VariablesMap variablesMap) {
        this.variablesMap = variablesMap;
    }

    @Override
    public void execute() {
        VariablesMap clonedVariablesMap = (VariablesMap) variablesMap.clone();

        clonedVariablesMap.forEach((s, complexNumber) -> System.out.println(s+" valore: "+complexNumber));
    }
}
