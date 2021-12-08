package it.unisa.se.calculator.model.operations.variable;
import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import it.unisa.se.calculator.model.VariablesMap;
import it.unisa.se.calculator.model.operations.Operation;
/**
 * The class extends the class Operation.
 * It provides a method to execute the storage of last stack element into the specified variable .
 */
public class SaveVariableOperation implements Operation {
    private String character;
    private VariablesMap variablesMap;

    public SaveVariableOperation(char character, VariablesMap variablesMap) {
        this.character = String.valueOf(character);
        this.variablesMap = variablesMap;
    }

    /**
     * This method allows the user to take the top value of the stack and store its value into the variable.
     * The value taken will be popped out of the stack.
     */
    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        ComplexNumber variableValue = complexNumberStack.pop();

        variablesMap.put(character, variableValue);

    }
}
