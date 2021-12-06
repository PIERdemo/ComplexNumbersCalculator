package it.unisa.se.calculator.model;

import it.unisa.se.calculator.exception.InvaidVariableNameException;
import it.unisa.se.calculator.exception.NotSupportedOperationException;
import it.unisa.se.calculator.interfaces.Observable;
import it.unisa.se.calculator.interfaces.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A Map containing 26 variables identified by a letter of the alphabet (a-z).
 * Each String variable will be associated with a ComplexNumber. The class also provides
 * a list of Observers to notify of any changes within the VariablesMap.
 * The class extend {@link HashMap} class and implements {@link Observable} class.
 */
public class VariablesMap extends HashMap<String,ComplexNumber> implements Observable{
    private List<Observer> stackObserver;

    public VariablesMap() {
        super();
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
        List<Entry<String, ComplexNumber>> entryList = this.entrySet().stream().sorted(Entry.comparingByKey()).toList();
        for (Observer observer : stackObserver) {
            observer.update(entryList);
        }
    }


}
