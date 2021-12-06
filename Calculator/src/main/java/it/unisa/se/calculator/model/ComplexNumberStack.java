package it.unisa.se.calculator.model;


import it.unisa.se.calculator.interfaces.Observable;
import it.unisa.se.calculator.interfaces.Observer;

import java.security.InvalidParameterException;
import java.util.*;

/**
 * The class extends the {@link java.util.Stack} class .
 * Provides an implementation of a ComplexNumbers stack.
 */
public class ComplexNumberStack extends Stack<ComplexNumber> implements Observable {

    private static ComplexNumberStack instance = null;
    private List<Observer> stackObserver;


    /**
     * This method provide an instance of a ComplexNumberStack.
     */
    public static ComplexNumberStack getInstance() {
        if (instance == null)
            instance = new ComplexNumberStack();
        return instance;
    }

    private ComplexNumberStack() {
        this.stackObserver = new ArrayList<>();
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

    public void addListener(Observer observer) {
        stackObserver.add(observer);
    }

    public void removeListener(Observer observer) {
        stackObserver.remove(observer);
    }


    public void notifyObservers() {
        for (Observer stackOb : stackObserver) {
            List<ComplexNumber> list =new ArrayList<>(this);
            Collections.reverse(list);
            stackOb.update(list);
        }
    }


    @Override
    public ComplexNumber push(ComplexNumber item) {
        super.push(item);
        notifyObservers();
        return item;
    }
    @Override
    public ComplexNumber pop() {
        ComplexNumber item =super.pop();
        notifyObservers();
        return item;
    }
    @Override
    public void clear() {
        super.clear();
        notifyObservers();
    }
}
