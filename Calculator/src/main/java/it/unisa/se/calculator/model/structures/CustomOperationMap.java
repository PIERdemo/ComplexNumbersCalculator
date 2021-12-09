package it.unisa.se.calculator.model.structures;

import it.unisa.se.calculator.model.observers.Observable;
import it.unisa.se.calculator.model.observers.Observer;

import java.io.*;
import java.util.*;

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
    public String remove(Object key) {
        String returnString = super.remove(key);
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

    public void saveInFile(File file){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for (Map.Entry<String, String> entry:super.entrySet()) {
                writer.write(entry.getKey() + "\t" + entry.getValue() + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void loadFromFile(File file){
        try {
            clear();
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] fields = line.split("\t");
                put(fields[0], fields[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
