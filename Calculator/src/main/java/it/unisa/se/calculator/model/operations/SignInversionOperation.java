package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
/**
 * The class implements the interface Operation
 * It provides a method to execute sign inversion.
 * */
public class SignInversionOperation implements Operation{
    /**
     * The function execute is used to calculate the sign inversion on the first operand taken from the stack.
     * Then it pushes the result into the stack.
     */
    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        ComplexNumber complexNumber1 = complexNumberStack.pop();

        ComplexNumber result = ComplexNumber.signInversion(complexNumber1);

        complexNumberStack.push(result);
    }
}
