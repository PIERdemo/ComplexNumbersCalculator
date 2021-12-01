package it.unisa.se.calculator.exception;

public class InvaidVariableNameException extends RuntimeException{
    public InvaidVariableNameException() {
    }

    public InvaidVariableNameException(String message) {
        super(message);
    }
}
