package it.unisa.se.calculator.model;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;


public class ComplexNumberStack implements Stack<ComplexNumber> {
    private ArrayList<ComplexNumber> list;
    private static ComplexNumberStack instance= null;

    private ComplexNumberStack() {
        this.list = new ArrayList<>();
    }


    public static ComplexNumberStack getInstance(){
        if(instance == null)
            instance = new ComplexNumberStack();
        return instance;
    }

    @Override
    public ComplexNumber pop() {
        ComplexNumber returnNumber = top();
        list.remove(list.size()-1);
        return returnNumber;
    }

    @Override
    public ComplexNumber top() {
        if(list.isEmpty())
            throw new EmptyStackException();
        return list.get(list.size()-1);
    }

    @Override
    public void push(ComplexNumber element)throws EmptyStackException {
        list.add(element);
    }

    public List<ComplexNumber> topKElements(int k){
        int startIndex = list.size()-k;
        if(startIndex < 0)
            startIndex = 0;
        return list.subList(startIndex,list.size());
    }

    public void over(){

    }

    public void swap(){

    }

    public void dup(){

    }

    public void drop(){

    }

    public void clear(){
        list.clear();
    }

}
