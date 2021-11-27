package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
/**
 * The class implements the interface Operation
 * It provides a method to execute Square root.
 * */
public class SquareRootOperation implements Operation {
    /**
     * The function execute is used to calculate the square root on the first operand taken from the stack.
     * Then it pushes the result into the stack.
     */
    @Override
    public void execute(){
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        ComplexNumber complexNumber1 = complexNumberStack.pop();

        ComplexNumber result = ComplexNumber.sqrt(complexNumber1);

        complexNumberStack.push(result);
    }
}
