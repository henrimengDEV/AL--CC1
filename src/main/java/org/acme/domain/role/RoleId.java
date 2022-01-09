package org.acme.domain.role;

import java.util.Objects;

public final class RoleId {

    private final int value;

    private RoleId(int value) {
        this.value = value;
    }

    public static RoleId of(int value) {
        return new RoleId(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleId roleId = (RoleId) o;
        return value == roleId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "RoleId{" +
                "value=" + value +
                '}';
    }
}
