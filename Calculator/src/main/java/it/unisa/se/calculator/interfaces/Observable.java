package it.unisa.se.calculator.interfaces;

import it.unisa.se.calculator.model.StackObserver;

public interface Observable {
    void addListener(Observer observer);
    void removeListener(Observer observer);
    void notifyObservers();
}
