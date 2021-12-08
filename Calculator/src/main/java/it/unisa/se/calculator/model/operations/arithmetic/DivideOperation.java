package it.unisa.se.calculator.model.operations.arithmetic;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import it.unisa.se.calculator.model.operations.Operation;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * The class extends the class Operation.
 * It provides a method to execute division.
 */

public class DivideOperation implements Operation {
    /**
     * The function execute is used to calculate the division between the first two operands taken from the stack.
     * Then it pushes the result into the stack.
     */

    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        List<ComplexNumber> operands = new ArrayList<>();
        complexNumberStack.getOperand(2).forEachRemaining(operands::add);
        ComplexNumber result;

        try {
            result = ComplexNumber.divide(operands.get(0), operands.get(1));
            complexNumberStack.push(result);
        } catch (InvalidParameterException e) {
            complexNumberStack.push(operands.get(1));
            complexNumberStack.push(operands.get(0));
            throw new InvalidParameterException("Undefined division, second operand must be different from 0+0j");
        }
    }
}
