package it.unisa.se.calculator.model.operations.trigonometric;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.structures.ComplexNumberStack;
import it.unisa.se.calculator.model.operations.Operation;

import java.util.ArrayList;
import java.util.List;



/**
 * The class extends the class Operation.
 * It provides a method to calculate the exponential.
 */
public class ExpOperation implements Operation {

    /**
     * The function execute is used to calculate the exponential of the first operand taken from the stack.
     * Then it pushes the result into the stack.
     */
    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        List<ComplexNumber> operands = new ArrayList<>();
        complexNumberStack.getOperand(1).forEachRemaining(operands::add);

        double real = operands.get(0).getReal();
        double imaginary = operands.get(0).getImaginary();


        double resultReal = Math.exp(real)*Math.cos(imaginary);
        double resultImaginary = Math.exp(real)*Math.sin(imaginary);

        complexNumberStack.push(new ComplexNumber (resultReal,resultImaginary));
    }
}
