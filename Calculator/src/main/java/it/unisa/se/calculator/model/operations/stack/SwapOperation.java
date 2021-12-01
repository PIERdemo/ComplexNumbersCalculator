package it.unisa.se.calculator.model.operations.stack;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import it.unisa.se.calculator.model.VariablesMap;
import it.unisa.se.calculator.model.operations.Operation;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * The class extends the class Operation.
 * It provides a method to execute Swap.
 * */
public class SwapOperation extends Operation {
    /**
     * The function execute is used to calculate the swap between the first two operands taken from the stack.
     * Then it pushes the result into the stack.
     */
    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        List<ComplexNumber> operands = new ArrayList<>();
        complexNumberStack.getOperand(2).forEachRemaining(operands::add);

        complexNumberStack.push(operands.get(0));
        complexNumberStack.push(operands.get(1));

    }


}
