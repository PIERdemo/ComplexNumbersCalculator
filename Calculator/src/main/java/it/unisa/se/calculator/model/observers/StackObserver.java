package it.unisa.se.calculator.model.observers;

import it.unisa.se.calculator.model.ComplexNumber;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

import java.util.List;

/**
 *  In order to allow the ComplexNumberStack class to use the Observer pattern,
 *  the following class is implemented.
 *  It implements {@link Observer} and extends {@link SimpleListProperty}.
 */
public class StackObserver extends SimpleListProperty<ComplexNumber> implements Observer {

    /**
     * Inizialize the observer with an observableArrayList {{@link FXCollections}}.
     */
    public StackObserver() {
        super(FXCollections.observableArrayList());
    }

    /**
     * The method provides an implementation of the update of list's content.
     * @param o an object passed that has to be set as the new content of the observer.
     */
    @Override
    public void update(Object o) {
        List<ComplexNumber> list = (List<ComplexNumber>) o;
        this.setAll(list);
    }
}
