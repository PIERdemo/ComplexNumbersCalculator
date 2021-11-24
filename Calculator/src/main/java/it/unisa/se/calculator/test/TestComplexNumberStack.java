package it.unisa.se.calculator.test;


import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.EmptyStackException;

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




}
