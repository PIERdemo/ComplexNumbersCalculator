package it.unisa.se.calculator.model;


import java.security.InvalidParameterException;
import java.util.*;
import java.util.function.Consumer;

/**
 * The class extends the {@link java.util.Stack} class .
 * Provides an implementation of a ComplexNumbers stack.
 */
public class ComplexNumberStack extends Stack<ComplexNumber> {
    private static ComplexNumberStack instance = null;

    /**
     * This method provide an instance of a ComplexNumberStack.
     */
    public static ComplexNumberStack getInstance() {
        if (instance == null)
            instance = new ComplexNumberStack();
        return instance;
    }

    /**
     * Constructor of a complex number.
     *
     * @param k specifies the int value which will be the length of the list of return values
     * @return a list of the last k elements(ComplexNumber) of the stack
     */
    public List<ComplexNumber> topKElements(int k) {

        List<ComplexNumber> renderedComplexNumbers = new ArrayList<>();
        while (k != 0 && !empty()) {
            renderedComplexNumbers.add(pop());
            k--;
        }
        for (int i = renderedComplexNumbers.size(); i > 0; i--) {
            push(renderedComplexNumbers.get(i - 1));
        }
        Collections.reverse(renderedComplexNumbers);
        return renderedComplexNumbers;


    }

    /**
     * This method provides a secure implementation of massive pop of operandNumber operands from the stack
     *
     * @param operandNumber specifies the number of operands to be taken from the stack
     * @return an iterator of complexNumber taken
     */
    public Iterator<ComplexNumber> getOperand(int operandNumber) {
        List<ComplexNumber> operands = new ArrayList<>();
        for (int i = 0; i < operandNumber; i++) {
            try {
                operands.add(pop());
            } catch (EmptyStackException e) {
                Collections.reverse(operands);
                operands.forEach(this::push);
                throw new InvalidParameterException("There aren't enough operands into the stack");
            }
        }
        return operands.iterator();
    }

}
