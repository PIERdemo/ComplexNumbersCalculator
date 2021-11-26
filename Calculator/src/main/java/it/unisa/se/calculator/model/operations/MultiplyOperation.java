package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;

public class MultiplyOperation implements Operation{
    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        ComplexNumber complexNumber1 = complexNumberStack.pop();
        ComplexNumber complexNumber2 = complexNumberStack.pop();

        ComplexNumber result = ComplexNumber.multiply(complexNumber1,complexNumber2);

        complexNumberStack.push(result);
    }
}
