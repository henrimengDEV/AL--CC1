package org.acme.domain.payment;

public final class Payment {

    private final PaymentId id;
    private final Order order;
    private double price;

    private Payment(PaymentId id, Order order) {
        this.id = id;
        this.order = order;
    }

    public static Payment of(PaymentId id, Order order) {
        return new Payment(id, order);
    }
}
