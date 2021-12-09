package it.unisa.se.calculator.model.structures;

import java.util.Stack;

/**
 * The class extends the {@link java.util.Stack} class.
 * Provides an implementation of a {@link VariablesMap} stack.
 */
public class VariablesMapStack extends Stack<VariablesMap> {
    private static VariablesMapStack instance = null;

    private VariablesMapStack() {
    }

    /**
     * This method provide an instance of a VariablesMapStack.
     */
    public static VariablesMapStack getInstance(){
        if (instance == null)
            instance = new VariablesMapStack();
        return instance;
    }
}
