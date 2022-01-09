package org.acme.domain.member;

import java.util.Objects;

public final class MemberId {

    private final int value;

    private MemberId(int value) {
        this.value = Objects.requireNonNull(value);
    }

    public static MemberId of(int value) {
        return new MemberId(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberId memberId = (MemberId) o;
        return value == memberId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
