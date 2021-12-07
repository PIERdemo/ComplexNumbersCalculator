package it.unisa.se.calculator.model.observers;

/**
 * The following interface is used to define methods for applying the Observer pattern.
 * Specifies an interface for updating objects after change.
 */
public interface Observer {
    void update(Object o);
}
