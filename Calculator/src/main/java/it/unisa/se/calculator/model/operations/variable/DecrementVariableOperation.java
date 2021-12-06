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
    private  String character;
    private VariablesMap variablesMap;

    public DecrementVariableOperation(char character, VariablesMap variablesMap) {
        this.character = String.valueOf(character);
        this.variablesMap = variablesMap;
    }

    /**
     * The function execute is used to take the
     * top element from the stack and subtract it to the value of a variable
     */

    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        ComplexNumber valueNumber = variablesMap.get(character);
        ComplexNumber topStackNumber = complexNumberStack.pop();

        ComplexNumber result = subtract(valueNumber,topStackNumber);
        variablesMap.put(character,result);
    }
}
