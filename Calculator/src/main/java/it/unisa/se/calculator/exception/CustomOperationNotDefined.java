package it.unisa.se.calculator.exception;

public class CustomOperationNotDefined extends RuntimeException{
    public CustomOperationNotDefined() {
    }

    public CustomOperationNotDefined(String message) {
        super(message);
    }
}
