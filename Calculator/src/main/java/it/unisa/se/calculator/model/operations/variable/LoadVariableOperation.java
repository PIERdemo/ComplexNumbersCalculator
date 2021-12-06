package it.unisa.se.calculator.model.operations.variable;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import it.unisa.se.calculator.model.VariablesMap;
import it.unisa.se.calculator.model.operations.Operation;

/**
 * The class extends the class Operation
 * It provides a method to execute the load operation on the stack.
 * */

public class LoadVariableOperation extends Operation {
    private String character;
    private VariablesMap variablesMap;

    public LoadVariableOperation(char character, VariablesMap variablesMap) {
        this.character = String.valueOf(character);
        this.variablesMap = variablesMap;
    }

    /**
     * The function execute is used to get a complexNumber relative to a variable and insert it into the stack.
     */
    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        ComplexNumber complexNumber = variablesMap.get(character);
        complexNumberStack.push(complexNumber);
    }




}
