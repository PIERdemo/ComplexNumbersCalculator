package it.unisa.se.calculator.model.structures;

import it.unisa.se.calculator.model.observers.Observable;
import it.unisa.se.calculator.model.observers.Observer;

import java.io.*;
import java.util.*;

/**
 * The class extends the {@link java.util.HashMap} class, with key and value type string.
 * It implements {@link Observable} interface.
 */
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

    /**
     * This method allows the values in the Map to be saved in a file.
     * @param file it indicates the file on which the map will be saved.
     */
    public void saveInFile(File file){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for (Map.Entry<String, String> entry:super.entrySet()) {
                writer.write(entry.getKey() + "\t" + entry.getValue() + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This method allows you to insert values into a Map from a file.
     * @param file it indicates the file from which the values will be loaded.
     */
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
