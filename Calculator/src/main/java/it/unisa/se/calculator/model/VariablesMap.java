package it.unisa.se.calculator.model;

import it.unisa.se.calculator.exception.InvaidVariableNameException;

import java.util.HashMap;

public class VariablesMap extends HashMap<String, ComplexNumber> {
    public VariablesMap() {
    }

    @Override
    public ComplexNumber put(String key, ComplexNumber value) {
        if (!key.matches("[a-z]"))
            throw new InvaidVariableNameException(key + " is not a valid name");
        return super.put(key, value);
    }
}
