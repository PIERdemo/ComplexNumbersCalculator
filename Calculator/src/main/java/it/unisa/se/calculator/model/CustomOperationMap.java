package it.unisa.se.calculator.model;

import it.unisa.se.calculator.model.observers.Observable;
import it.unisa.se.calculator.model.observers.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomOperationMap extends HashMap<String, String> implements Observable {
    private List<Observer> observerList;

    public CustomOperationMap() {
        super();
        this.observerList = new ArrayList<>();
    }

    @Override
    public String get(Object key) {
        String returnString = super.get(key);
        notifyObservers();
        return returnString;
    }

    @Override
    public String put(String key, String value) {
        String returnString = super.put(key, value);
        notifyObservers();
        return returnString;
    }

    @Override
    public void addListener(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeListener(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        List<Entry<String, String>> entryList = this.entrySet().stream().sorted(Entry.comparingByKey()).toList();
        for (Observer observer : observerList) {
            observer.update(entryList);
        }
    }
}
