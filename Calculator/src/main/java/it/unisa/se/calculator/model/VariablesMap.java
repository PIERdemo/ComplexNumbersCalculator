package it.unisa.se.calculator.model;

import it.unisa.se.calculator.exception.InvaidVariableNameException;
import it.unisa.se.calculator.exception.NotSupportedOperationException;
import it.unisa.se.calculator.interfaces.Observable;
import it.unisa.se.calculator.interfaces.Observer;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;


/**
 * a Map containing 26 variables identified by a letter of the alphabet (a-z).
 * Each String variable is associated with a CompleNumber.
 * The class extend HashMap class {@link HashMap}
 */
public class VariablesMap extends SimpleMapProperty<String,ComplexNumber> implements Observable {
    private List<Observer> stackObserver;

    public VariablesMap() {
        super(FXCollections.observableHashMap());
        stackObserver = new ArrayList<>();
    }


    @Override
    public ComplexNumber get(Object key) {
        ComplexNumber returnComplexNumber = super.get(key);
        if(returnComplexNumber == null)
            throw new NotSupportedOperationException("variable "+ key +" has not a value yet ");
        notifyObservers();
        return returnComplexNumber;
    }

    @Override
    public ComplexNumber put(String key, ComplexNumber value) {
        if (!key.matches("[a-z]"))
            throw new InvaidVariableNameException(key + " is not a valid name");
        ComplexNumber complexNumber = super.put(key, value);
        notifyObservers();
        return complexNumber;
    }


    @Override
    public void addListener(Observer observer) {
        stackObserver.add(observer);
    }

    @Override
    public void removeListener(Observer observer) {
        stackObserver.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : stackObserver) {
            observer.update(this.entrySet().stream().toList());
        }
    }
}
