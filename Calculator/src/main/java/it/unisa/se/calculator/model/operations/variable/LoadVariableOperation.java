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

    /**
     * The function execute is used to get a complexNumber relative to a variable and insert it into the stack
     * @param variablesMap the map of all variables from a to z
     * @param variable the variable whose value is taken
     */
    @Override
    public void execute(VariablesMap variablesMap, String variable) {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        ComplexNumber complexNumber = variablesMap.get(variable);
        complexNumberStack.push(complexNumber);
    }




}
