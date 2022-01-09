package org.acme.domain.product;

public class Product {

    private final int id;
    private final String name;
    private final String description;
    private final double price;

    private Product(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static Product of(int id, String name, String description, double price) {
        return new Product(id, name, description, price);
    }
}
