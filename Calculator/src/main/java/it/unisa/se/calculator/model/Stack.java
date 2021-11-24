package it.unisa.se.calculator.model;

public interface Stack<T> {

    public T pop();
    public T top();
    public void push(T element);

}
