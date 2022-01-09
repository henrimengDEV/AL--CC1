package org.acme.exposition.product;

import org.acme.domain.product.Product;

public final class ProductResponse {

    public String id;
    public String name;
    public String description;
    public double price;

    private ProductResponse(String id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static ProductResponse of(Product product) {
        return new ProductResponse(product.getId().toString(), product.getName(), product.getDescription(), product.getPrice());
    }
}
