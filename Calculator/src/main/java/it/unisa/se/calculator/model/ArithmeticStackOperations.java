package it.unisa.se.calculator.model;

public class ArithmeticStackOperations {
    private ComplexNumberStack numberStack;

    public ArithmeticStackOperations() {
        numberStack = ComplexNumberStack.getInstance();
    }
    public void subtract() {
        ComplexNumber complexNumber1 = numberStack.pop();
        ComplexNumber complexNumber2 = numberStack.pop();

        ComplexNumber result = ComplexNumber.subtract(complexNumber1,complexNumber2);

        numberStack.push(result);

    }
    public void sum(){
        ComplexNumber complexNumber1 = numberStack.pop();
        ComplexNumber complexNumber2 = numberStack.pop();

        ComplexNumber result = ComplexNumber.sum(complexNumber1,complexNumber2);

        numberStack.push(result);
    }

    public void multiply (){
        ComplexNumber complexNumber1 = numberStack.pop();
        ComplexNumber complexNumber2 = numberStack.pop();

        ComplexNumber result = ComplexNumber.multiply(complexNumber1,complexNumber2);

        numberStack.push(result);
    }

}
