package it.unisa.se.calculator.model.operations.positional;

import it.unisa.se.calculator.model.structures.ComplexNumberStack;
import it.unisa.se.calculator.model.operations.Operation;

/**
 * The class extends the class Operation.
 * It provides a method to execute the clear operation on the stack.
 * */
public class ClearOperation implements Operation {
    /**
     * The function execute is used to remove all operands from the stack.
     */
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        complexNumberStack.clear();

    }
}
