package it.unisa.se.calculator.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * The class extends the {@link java.util.Stack} class .
 * Provides an implementation of a ComplexNumbers stack.
 *
 */
public class ComplexNumberStack extends Stack<ComplexNumber>{
    private static ComplexNumberStack instance= null;

    /**
     * This method provide an instance of a ComplexNumberStack.
     */
    public static ComplexNumberStack getInstance(){
        if(instance == null)
            instance = new ComplexNumberStack();
        return instance;
    }

    /**
     * Constructor of a complex number.
     * @param k specifies the int value which will be the length of the list of return values
     * @return a list of the last k elements(ComplexNumber) of the stack
     */
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
        return renderedComplexNumbers;


    }

}
