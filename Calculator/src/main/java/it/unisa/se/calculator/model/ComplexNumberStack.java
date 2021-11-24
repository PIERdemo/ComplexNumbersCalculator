package it.unisa.se.calculator.model;

import java.util.List;

public class ComplexNumberStack implements Stack<ComplexNumber> {
    private List<ComplexNumber> list;

    public ComplexNumberStack(List<ComplexNumber> list) {
        this.list = list;
    }

    @Override
    public ComplexNumber pop() {
        return null;
    }

    @Override
    public ComplexNumber top() {
        return null;
    }

    @Override
    public void push(ComplexNumber element) {

    }
}
