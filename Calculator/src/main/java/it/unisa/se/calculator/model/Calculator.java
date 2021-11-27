package it.unisa.se.calculator.model;

import it.unisa.se.calculator.model.operations.OperationInvoker;

/**
 * The class calculator provides an implementation of calculator's logic.
 * It analyses the input and if it is a number, it is saved onto the stack, if it is
 * an operation it is executed, otherwise an error occurs.
 *
 * The class has the stack of complex numbers, which stores the operands and
 * an object OperationInvoker which allows the invocation of operations.
 */
public class Calculator {

    private ComplexNumberStack complexNumberStack;
    private OperationInvoker operationInvoker;

    public Calculator() {
        complexNumberStack = ComplexNumberStack.getInstance();
        operationInvoker = new OperationInvoker();
    }

    /**
     * The method allows verifying if the string in input is a number or an operation.
     * If the string is a number, the method save number is called, otherwise an operation is invoked.
     * @param s incoming string that has to be analyzed
     */
    public void inputDispatcher(String s) {

       String formattedNumber = getFormattedNumber(s);
       if(formattedNumber !=null)
           saveNumber(formattedNumber);
       else
           operationInvoker.execute(s.replaceAll("\\s+", ""));


    }

    /**
     *
     * The method is invoked to check if the string in input is a representation of a number.
     * If so, the string is adjusted according to a specific format +/-XX.XX+/-XX.XXj.
     * Otherwise, a null string is returned.
     * @param s string that has to be analyzed
     * @return a formatted string if s is a number, otherwise null.
     */
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

    /**
     * The method allows the storage of a number expressed as a string into the stack of operands.
     * The string in input is read as a complex number, and then it is saved.
     * @param s string representing a complex number
     */

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
