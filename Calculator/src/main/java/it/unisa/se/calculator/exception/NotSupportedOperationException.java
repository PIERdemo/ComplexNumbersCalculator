package it.unisa.se.calculator.exception;

public class NotSupportedOperationException extends RuntimeException{
    public NotSupportedOperationException() {
    }

    public NotSupportedOperationException(String message) {
        super(message);
    }
}
