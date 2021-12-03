package it.unisa.se.calculator.model;

import it.unisa.se.calculator.interfaces.Observer;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

import java.util.List;


public class StackObserver extends SimpleListProperty<ComplexNumber> implements Observer {

    public StackObserver() {
        super(FXCollections.observableArrayList());
    }

    public void update(List<ComplexNumber> list) {
        this.setAll(list);
    }
}
