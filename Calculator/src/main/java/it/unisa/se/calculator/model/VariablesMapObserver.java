package it.unisa.se.calculator.model;

import it.unisa.se.calculator.interfaces.Observer;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

import java.util.List;
import java.util.Map;

public class VariablesMapObserver extends SimpleListProperty<Map.Entry<String,ComplexNumber>> implements Observer {

    public VariablesMapObserver() {
        super(FXCollections.observableArrayList());
    }

    public void update(Object o) {
        List<Map.Entry<String,ComplexNumber>> list = (List<Map.Entry<String, ComplexNumber>>) o;
        this.setAll(list);
    }
}