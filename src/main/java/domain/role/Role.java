package domain.role;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public final class Role {

    private final RoleId id;
    private final String name;
    private final BigDecimal price;

    private Role(RoleId id, String name, BigDecimal price) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.price = Objects.requireNonNull(price);
    }

    public static Role of(RoleId id, String name, BigDecimal price) {
        return new Role(id, name, price);
    }

    public RoleId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
