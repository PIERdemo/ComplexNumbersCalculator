package it.unisa.se.calculator.test;


import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.List;
import java.util.function.Consumer;

public class TestComplexNumberStack {
    private ComplexNumberStack numberStack;
    @Before
    public void setUp(){
        numberStack = new ComplexNumberStack();
    }



    @Test
    public void testPop(){
        numberStack.clear();

        numberStack.push(new ComplexNumber(3.0,3.0));
        assertEquals(numberStack.pop(),new ComplexNumber(3.0,3.0));

        numberStack.push(new ComplexNumber(3.0,-3.0));
        assertEquals(numberStack.pop(),new ComplexNumber(3.0,-3.0));

        numberStack.push(new ComplexNumber(-3.0,3.0));
        assertEquals(numberStack.pop(),new ComplexNumber(-3.0,3.0));

        numberStack.push(new ComplexNumber(-3.0,-3.0));
        assertEquals(numberStack.pop(),new ComplexNumber(-3.0,-3.0));
    }

    @Test(expected = EmptyStackException.class)
    public void testPopWithEmptyStack(){
        numberStack.clear();
        numberStack.pop();
    }

    @Test
    public void testPush(){
        numberStack.clear();
        numberStack.push(new ComplexNumber(5.0,5.0));
        assertEquals(numberStack.top(),new ComplexNumber(5.0,5.0));

        numberStack.push(new ComplexNumber(-5.0,5.0));
        assertEquals(numberStack.top(),new ComplexNumber(-5.0,5.0));

        numberStack.push(new ComplexNumber(5.0,-5.0));
        assertEquals(numberStack.top(),new ComplexNumber(5.0,-5.0));

        numberStack.push(new ComplexNumber(-5.0,-5.0));
        assertEquals(numberStack.top(),new ComplexNumber(-5.0,-5.0));

    }


    @Test
    public void testTop(){
        numberStack.clear();
        for(int i =0; i<10;i++)
            numberStack.push(new ComplexNumber(i+1,i+1));
        assertEquals(numberStack.top(),new ComplexNumber(10.0,10.0));

        for(int i =0; i<10;i++)
            numberStack.push(new ComplexNumber(i+1,-(i+1)));
        assertEquals(numberStack.top(),new ComplexNumber(10.0,-10.0));

        for(int i =0; i<10;i++)
            numberStack.push(new ComplexNumber(-(i+1),i+1));
        assertEquals(numberStack.top(),new ComplexNumber(-10.0,10.0));

        for(int i =0; i<10;i++)
            numberStack.push(new ComplexNumber(-(i+1),-(i+1)));
        assertEquals(numberStack.top(),new ComplexNumber(-10.0,-10.0));

    }

    @Test(expected = EmptyStackException.class)
    public void testTopWithEmptyStack(){
        numberStack.clear();
        numberStack.top();
    }

    @Test
    public void testTopKElements(){
        numberStack.clear();
        for(int i =0; i<10;i++)
            numberStack.push(new ComplexNumber(i+1,i+1));

        int k = 5;
        List<ComplexNumber> topKElements = numberStack.topKElements(k);
        for(int i=0;i<topKElements.size();i++){
            assertEquals(topKElements.get(i),new ComplexNumber(i+1+k,i+1+k));
        }

        //test with empty stack
        numberStack.clear();
        topKElements = numberStack.topKElements(k);
        assertEquals(topKElements.size(),0);


        //test with few values than required
        for(int i =0; i<2;i++)
            numberStack.push(new ComplexNumber(i+1,i+1));

        topKElements = numberStack.topKElements(k);
        for(int i=0;i<topKElements.size();i++){
            assertEquals(topKElements.get(i),new ComplexNumber(i+1,i+1));
        }
    }




}
