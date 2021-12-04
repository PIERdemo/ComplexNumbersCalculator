package it.unisa.se.calculator.model;

import it.unisa.se.calculator.interfaces.Observer;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

import java.util.List;
import java.util.Map;

/**
 *  In order to allow the VariablesMap class to use the Observer pattern,
 *  the following class is implemented.
 *  It implements {@link Observer} and extends {@link SimpleListProperty}.
 */
public class VariablesMapObserver extends SimpleListProperty<Map.Entry<String,ComplexNumber>> implements Observer {
    /**
     * Inizialize the observer with an observableArrayList {{@link FXCollections}}.
     */
    public VariablesMapObserver() {
        super(FXCollections.observableArrayList());
    }

    @Override
    public void update(Object o) {
        List<Map.Entry<String,ComplexNumber>> list = (List<Map.Entry<String, ComplexNumber>>) o;
        this.setAll(list);
    }
}