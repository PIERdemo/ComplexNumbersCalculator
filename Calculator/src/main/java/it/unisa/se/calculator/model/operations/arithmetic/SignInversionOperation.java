package it.unisa.se.calculator.model.operations.arithmetic;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import it.unisa.se.calculator.model.operations.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * The class extends the class Operation.
 * It provides a method to execute sign inversion.
 * */
public class SignInversionOperation implements Operation {
    /**
     * The function execute is used to calculate the sign inversion on the first operand taken from the stack.
     * Then it pushes the result into the stack.
     */
    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        List<ComplexNumber> operands = new ArrayList<>();
        complexNumberStack.getOperand(1).forEachRemaining(operands::add);


        ComplexNumber result = ComplexNumber.signInversion(operands.get(0));
        complexNumberStack.push(result);
    }
}
