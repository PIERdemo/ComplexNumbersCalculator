package it.unisa.se.calculator.model;

public class Calculator {

    private ComplexNumberStack complexNumberStack;

    public Calculator(ComplexNumberStack complexNumberStack) {
        this.complexNumberStack = complexNumberStack;
    }

    public String InputDispatcher(String s){

        String onlyReal = "[\\+\\- ]?[0-9]+";
        String onlyImaginary = "[ ]?[\\+\\-][0-9]+[ij]";
        String fullComplexNumber = "[\\+\\- ]?[0-9]+[ ]?[\\+\\-][0-9]+[ij]";

        if (s.matches(onlyReal) || s.matches(onlyImaginary) || s.matches(fullComplexNumber))
            return "saveNumber(s)";
        else
           return "executeOperation(s)";
    }


}
