package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
/**
 * The class implements the interface Operation
 * It provides a method to execute subtraction.
 * */
public class SubtractOperation implements  Operation{
    /**
     * The function execute is used to calculate the subtraction between the first two operands taken from the stack.
     * Then it pushes the result into the stack.
     */
    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        ComplexNumber complexNumber1 = complexNumberStack.pop();
        ComplexNumber complexNumber2 = complexNumberStack.pop();

        ComplexNumber result = ComplexNumber.subtract(complexNumber1,complexNumber2);

        complexNumberStack.push(result);
    }
}
