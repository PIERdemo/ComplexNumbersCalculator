package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.model.ComplexNumberStack;
/**
 * The class implements the interface Operation
 * It provides a method to execute the clear operation on the stack.
 * */
public class ClearOperation implements Operation{
    /**
     * The function execute is used to remove all operands from the stack.
     */
    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        complexNumberStack.clear();

    }
}
