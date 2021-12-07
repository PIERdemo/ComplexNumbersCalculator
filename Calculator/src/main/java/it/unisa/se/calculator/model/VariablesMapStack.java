package it.unisa.se.calculator.model;

import java.util.Stack;

public class VariablesMapStack extends Stack<VariablesMap> {
    private static VariablesMapStack instance = null;

    private VariablesMapStack() {
    }

    public static VariablesMapStack getInstance(){
        if (instance == null)
            instance = new VariablesMapStack();
        return instance;
    }
}
