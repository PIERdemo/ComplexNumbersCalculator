package it.unisa.se.calculator.interfaces;

import it.unisa.se.calculator.model.StackObserver;

public interface Observable {
    void addListener(StackObserver observer);
    void removeListener(StackObserver observer);
    void notifyObservers();
}
