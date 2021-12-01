package it.unisa.se.calculator.model.operations.variable;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import it.unisa.se.calculator.model.VariablesMap;
import it.unisa.se.calculator.model.operations.Operation;
import static it.unisa.se.calculator.model.ComplexNumber.*;

/**
 * The class implements the interface Operation
 * It provides a method that takes the
 * top element from the stack and subtract it to the value of a variable
 * */
public class DecrementVariableOperation extends Operation {

    /**
     * The function execute is used to take the
     * top element from the stack and subtract it to the value of a variable
     * @param variablesMap a Map containing all occurrences of previously saved variables
     * @param variable a String containing the variable to be modified
     */

    @Override
    public void execute(VariablesMap variablesMap, String variable) {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        ComplexNumber valueNumber = variablesMap.get(variable);
        ComplexNumber topStackNumber = complexNumberStack.pop();

        ComplexNumber result = subtract(valueNumber,topStackNumber);
        variablesMap.put(variable,result);
    }
}
