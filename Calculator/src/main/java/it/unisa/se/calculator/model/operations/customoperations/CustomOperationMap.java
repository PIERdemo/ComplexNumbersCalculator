package it.unisa.se.calculator.model.operations.customoperations;

import it.unisa.se.calculator.exception.CustomOperationDefined;
import it.unisa.se.calculator.exception.CustomOperationNotDefined;
import org.apache.commons.lang3.tuple.MutableTriple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomOperationMap extends HashMap<String, MutableTriple<String, ArrayList<String>, ArrayList<String>>> {
    private static CustomOperationMap instance = null;

    public static CustomOperationMap getInstance() {
        if (instance == null)
            instance = new CustomOperationMap();
        return instance;
    }

    private CustomOperationMap() {

    }

    /**
     * method remove
     */
    public MutableTriple<String, ArrayList<String>, ArrayList<String>> removeAtKey(String key) {
        MutableTriple<String, ArrayList<String>, ArrayList<String>> triple = get(key);

        if (triple == null)
            throw new CustomOperationNotDefined("operation " + key + " not supported yet");

        List<String> appearsIn = new ArrayList<>(triple.getMiddle());

        if (appearsIn.size() != 0) {
            for (String customOperation : appearsIn) {
                removeAtKey(customOperation);
            }
        }

        List<String> hasA = new ArrayList<>(triple.getRight());

        for (String customOperation : hasA) {
            get(customOperation).getMiddle().remove(key);
        }

        return remove(key);
    }

    /**
     * method add
     */
    public void addCustomOperation(String key, String operationString) {

        //verify if the operation is already defined
        MutableTriple<String, ArrayList<String>, ArrayList<String>> triple = get(key);

        if (triple != null)
            throw new CustomOperationDefined("operation " + key + " already supported");


        MutableTriple<String, ArrayList<String>, ArrayList<String>> value = new MutableTriple<>(operationString, new ArrayList<>(), new ArrayList<>());

        updateMiddleColumn(key, operationString, value);

        put(key, value);
    }

    private void updateMiddleColumn(String key, String operationString, MutableTriple<String, ArrayList<String>, ArrayList<String>> value) {
        ArrayList<String> rightElement = new ArrayList<>();
        String[] operations = operationString.split(" ");

        for (String operation : operations)
            if (get(operation) != null) {
                if(!rightElement.contains(operation))
                    rightElement.add(operation);
                ArrayList<String> middle = get(operation).getMiddle();
                if(!middle.contains(key))
                    middle.add(key);
                get(operation).setMiddle(middle);
            }
        value.setRight(rightElement);
    }

    /**
     * method modify
     */
    public void modifyOperation(String key, String operationString){
        MutableTriple<String, ArrayList<String>, ArrayList<String>> oldValue =  get(key);

        get(key).setLeft(operationString);

        updateMiddleColumn(key, operationString, oldValue);

        get(key).setRight(oldValue.getRight());
    }

}
