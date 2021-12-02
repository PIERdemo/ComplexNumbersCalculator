package it.unisa.se.calculator.model;

import it.unisa.se.calculator.exception.InvaidVariableNameException;
import it.unisa.se.calculator.exception.NotSupportedOperationException;

import java.util.HashMap;


/**
 * a Map containing 26 variables identified by a letter of the alphabet (a-z).
 * Each String variable is associated with a CompleNumber.
 * The class extend HashMap class {@link HashMap}
 */
public class VariablesMap extends HashMap<String, ComplexNumber> {
    public VariablesMap() {
    }

    @Override
    public ComplexNumber get(Object key) {
        ComplexNumber returnComplexNumber = super.get(key);
        if(returnComplexNumber == null)
            throw new NotSupportedOperationException("variable "+ key +" has not a value yet ");
        return returnComplexNumber;
    }

    @Override
    public ComplexNumber put(String key, ComplexNumber value) {
        if (!key.matches("[a-z]"))
            throw new InvaidVariableNameException(key + " is not a valid name");
        return super.put(key, value);
    }
}
