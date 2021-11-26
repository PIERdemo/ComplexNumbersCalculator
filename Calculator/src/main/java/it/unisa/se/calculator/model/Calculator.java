package it.unisa.se.calculator.model;

import it.unisa.se.calculator.model.operations.OperationInvoker;

public class Calculator {

    private ComplexNumberStack complexNumberStack;
    private OperationInvoker operationInvoker;

    public Calculator() {
        complexNumberStack = ComplexNumberStack.getInstance();
        operationInvoker = new OperationInvoker();
    }

    public void inputDispatcher(String s) {

       String formattedNumber = getFormattedNumber(s);
       if(formattedNumber !=null)
           saveNumber(formattedNumber);
       else
           operationInvoker.execute(s.replaceAll("\\s+",""));
    }


    private String getFormattedNumber(String s) {
        String onlyReal = "[\\+\\-]?((([0-9]*).([0-9]+))|([0-9]+))";
        String onlyImaginary = "[\\+|\\-|\\s]?((([0-9]*).([0-9]+))|([0-9]+))[ij]";
        String fullComplexNumber = "[\\+\\- ]?((([0-9]*).([0-9]+))|([0-9]+))[ ]?[\\+\\-]((([0-9]*).([0-9]+))|([0-9]+))[ij]";

        if (s.matches(fullComplexNumber))
            return s;
        else if (s.matches(onlyReal))
            return s + "+0j";
        else if (s.matches(onlyImaginary)) {
            s = ((s.charAt(0) + "").matches("[0-9]")) ? ("+" + s) : s;
            return "+0" + s;
        }
        return null;
    }

    private void saveNumber(String s) {
        if (s.charAt(0) != '-' && s.charAt(0) != '+')
            s = "+" + s;
        int realSign = 1, imaginarySign = 1;

        if (s.matches(".*-.*-.*")) {
            realSign = -1;
            imaginarySign = -1;
        } else {
            int minusPosition = s.indexOf("-");
            if (minusPosition != -1) {
                if (minusPosition == 0)
                    realSign = -1;
                else
                    imaginarySign = -1;
            }
        }
        s = s.replaceAll("j", "");
        String[] numbers = s.split("[\\+|\\-]");
        complexNumberStack.push(new ComplexNumber(realSign * Double.parseDouble(numbers[1]), imaginarySign * Double.parseDouble(numbers[2])));
    }


}
