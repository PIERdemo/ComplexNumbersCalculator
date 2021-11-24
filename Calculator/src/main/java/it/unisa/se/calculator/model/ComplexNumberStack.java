package it.unisa.se.calculator.model;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;
        import java.util.Stack;


public class ComplexNumberStack extends Stack<ComplexNumber>{
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
        return renderedComplexNumbers;
    }

    public void subtract() {
        ComplexNumber complexNumber1 = pop();
        ComplexNumber complexNumber2 = pop();

        ComplexNumber result = ComplexNumber.subtract(complexNumber1,complexNumber2);

        push(result);

    }
    public void sum(){
        ComplexNumber complexNumber1 = pop();
        ComplexNumber complexNumber2 = pop();

        ComplexNumber result = ComplexNumber.sum(complexNumber1,complexNumber2);

        push(result);
    }

    public void multiply (){
        ComplexNumber complexNumber1 = pop();
        ComplexNumber complexNumber2 = pop();

        ComplexNumber result = ComplexNumber.multiply(complexNumber1,complexNumber2);

        push(result);
    }

    public void divide (){
        ComplexNumber complexNumber1 = pop();
        ComplexNumber complexNumber2 = pop();

        ComplexNumber result = ComplexNumber.divide(complexNumber1,complexNumber2);

        push(result);
    }

    public void over(){

    }

    public void swap(){

    }

    public void dup(){

    }

    public void drop(){

    }
/*
    public void clear(){
        list.clear();
    }
*/
}
