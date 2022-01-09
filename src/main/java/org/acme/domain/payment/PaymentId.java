package org.acme.domain.payment;

public class PaymentId {

    private final int value;

    private PaymentId(int value) {
        this.value = value;
    }

    public PaymentId of(int value) {
        return new PaymentId(value);
    }
}
