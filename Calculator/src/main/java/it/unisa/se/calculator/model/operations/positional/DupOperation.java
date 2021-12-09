package it.unisa.se.calculator.model.operations.positional;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.structures.ComplexNumberStack;
import it.unisa.se.calculator.model.operations.Operation;

import java.util.ArrayList;
import java.util.List;
/**
 * The class extends the class Operation.
 * It provides a method to execute an insertion onto the stack of a last stack element's copy.
 * */
public class DupOperation implements Operation {
    /**
     * The function execute is used to insert a copy of the last element onto the stack.
     */
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        List<ComplexNumber> operands = new ArrayList<>();
        complexNumberStack.getOperand(1).forEachRemaining(operands::add);
        ComplexNumber lastElement = operands.get(0);
        complexNumberStack.push(lastElement);
        complexNumberStack.push(lastElement);
    }
}
