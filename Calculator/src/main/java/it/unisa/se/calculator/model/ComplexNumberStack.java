package it.unisa.se.calculator.model;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class ComplexNumberStack extends Stack<ComplexNumber> {
    private static ComplexNumberStack instance= null;

    private ComplexNumberStack() {
    }


    public static ComplexNumberStack getInstance(){
        if(instance == null)
            instance = new ComplexNumberStack();
        return instance;
    }



    public List<ComplexNumber> topKElements(int k){

        List<ComplexNumber> renderedComplexNumbers = new ArrayList<>();
        while(k!=0 && !empty()){
            renderedComplexNumbers.add(pop());
            k--;
        }
        for ( int i = renderedComplexNumbers.size(); i>0; i--){
            push(renderedComplexNumbers.get(i-1));
        }
        Collections.reverse(renderedComplexNumbers);
        ObservableList<ComplexNumber> list =FXCollections.observableArrayList(renderedComplexNumbers);
        return list;
    }

}
