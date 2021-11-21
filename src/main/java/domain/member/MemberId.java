package domain.member;

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
        return "MemberId{" +
                "value='" + value + '\'' +
                '}';
    }
}
