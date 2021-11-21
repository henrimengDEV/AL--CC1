package domain.role;

import java.math.BigDecimal;

public class CreateRole {

    public String name;
    public BigDecimal price;

    public CreateRole(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
