package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;

public class SignInversionOperation implements Operation{
    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        ComplexNumber complexNumber1 = complexNumberStack.pop();

        ComplexNumber result = ComplexNumber.signInversion(complexNumber1);

        complexNumberStack.push(result);
    }
}
