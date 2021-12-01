package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * The class implements the interface Operation
 * It provides a method to execute Drop.
 * */
public class DropOperation implements Operation{
    /**
     * The function execute is used to calculate the drop of the top operand of the stack.
     */
    @Override
    public void execute() {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        complexNumberStack.pop();
    }
}