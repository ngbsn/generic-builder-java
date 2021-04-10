package org.punto11.exception;

public class GenericBuilderException extends RuntimeException{
    public GenericBuilderException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
