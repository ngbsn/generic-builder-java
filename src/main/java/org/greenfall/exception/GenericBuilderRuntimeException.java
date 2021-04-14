package org.greenfall.exception;

public class GenericBuilderRuntimeException extends RuntimeException {
    public GenericBuilderRuntimeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
