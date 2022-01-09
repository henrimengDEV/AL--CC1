package org.acme.kernel.exception;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(int id) {
        return new NoSuchEntityException(String.format("No entity found with ID %d.", id));
    }
}
