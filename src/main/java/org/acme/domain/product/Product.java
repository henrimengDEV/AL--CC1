package org.acme.domain.product;

public class Product {

    private final ProductId id;
    private final String name;
    private final String description;
    private final double price;

    private Product(ProductId id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static Product of(ProductId id, String name, String description, double price) {
        return new Product(id, name, description, price);
    }

    public ProductId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
