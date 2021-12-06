package it.unisa.se.calculator.exception;

public class CustomOperationDefined extends RuntimeException{
    public CustomOperationDefined() {
    }

    public CustomOperationDefined(String message) {
        super(message);
    }
}
