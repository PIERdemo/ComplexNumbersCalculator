package it.unisa.se.calculator.model.operations.positional;

import it.unisa.se.calculator.model.ComplexNumberStack;
import it.unisa.se.calculator.model.operations.Operation;

/**
 * The class extends the class Operation.
 * It provides a method to execute the clear operation on the stack.
 * */
public class ClearOperation implements Operation {
    /**
     * The function execute is used to remove all operands from the stack.
     */
    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = it.unisa.se.calculator.model.ComplexNumberStack.getInstance();
        complexNumberStack.clear();

    }
}
