package domain.role;

import java.util.Objects;

public class RoleId {

    private final int value;

    private RoleId(int value) {
        this.value = Objects.requireNonNull(value);
    }

    public static RoleId of(int value) {
        return new RoleId(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "RoleId{" +
                "value=" + value +
                '}';
    }
}
