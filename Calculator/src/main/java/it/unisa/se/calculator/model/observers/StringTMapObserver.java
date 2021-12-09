package it.unisa.se.calculator.model.observers;

import it.unisa.se.calculator.model.ComplexNumber;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

import java.util.List;
import java.util.Map;

/**
 *  In order to allow the VariablesMap class to use the Observer pattern,
 *  the following class is implemented.
 *  It implements {@link Observer} and extends {@link SimpleListProperty}.
 */
public class StringTMapObserver<T> extends SimpleListProperty<Map.Entry<String, T>> implements Observer {
    /**
     * Inizialize the observer with an observableArrayList {{@link FXCollections}}.
     */
    public StringTMapObserver() {
        super(FXCollections.observableArrayList());
    }
    /**
     * The method provides an implementation of the update of list's content.
     * @param o an object passed that has to be set as the new content of the observer.
     */
    @Override
    public void update(Object o) {
        List<Map.Entry<String,T>> list = (List<Map.Entry<String, T>>) o;
        this.setAll(list);
    }
}