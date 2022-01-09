package org.acme.domain.member;

public class InvalidMemberAttributeValueException extends RuntimeException {

    public InvalidMemberAttributeValueException(String errorMessage) {
        super(errorMessage);
    }
}
