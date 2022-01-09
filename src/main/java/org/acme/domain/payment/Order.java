package org.acme.domain.payment;

import org.acme.domain.product.Product;

import java.util.List;

public class Order {

    private final List<Product> products;
    private final double price;

    private Order(List<Product> products, double price) {
        this.products = products;
        this.price = price;
    }

    public static Order of(List<Product> products, double price) {
        return new Order(products, price);
    }
}
