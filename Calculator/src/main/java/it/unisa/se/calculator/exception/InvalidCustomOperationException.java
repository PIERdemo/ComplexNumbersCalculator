package it.unisa.se.calculator.exception;

public class InvalidCustomOperationException extends RuntimeException{
    public InvalidCustomOperationException(String message) {
        super(message);
    }

    public InvalidCustomOperationException() {
    }
}
