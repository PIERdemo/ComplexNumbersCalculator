package it.unisa.se.calculator.model.operations.variable;

import it.unisa.se.calculator.model.VariablesMap;
import it.unisa.se.calculator.model.operations.Operation;

public class DecrementVariableOperation extends Operation {




    @Override
    public void execute(VariablesMap variablesMap, String variable) {
        System.out.println("CIao+"+variable);
    }
}
