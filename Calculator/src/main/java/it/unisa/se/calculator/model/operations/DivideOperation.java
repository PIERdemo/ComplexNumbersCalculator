package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;

import java.security.InvalidParameterException;

public class DivideOperation implements  Operation{
    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        ComplexNumber complexNumber1 = complexNumberStack.pop();
        ComplexNumber complexNumber2 = complexNumberStack.pop();

        ComplexNumber result;
        try {
            result = ComplexNumber.divide(complexNumber1,complexNumber2);
            complexNumberStack.push(result);
        }catch (InvalidParameterException e){
            complexNumberStack.push(complexNumber2);
            complexNumberStack.push(complexNumber1);
            throw new InvalidParameterException("Undefined division, second operand must be different from 0+0i");
        }
    }
}
