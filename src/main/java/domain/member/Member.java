package domain.member;

import domain.role.Role;

import java.util.Objects;

public final class Member {

    private final MemberId id;
    private final String firstName;
    private final String lastName;
    private final Login memberLogin;
    private final Role role;

    private Member(MemberId id, String firstName, String lastName, Login memberLogin, Role role) {
        this.id = Objects.requireNonNull(id);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.memberLogin = Objects.requireNonNull(memberLogin);
        this.role = Objects.requireNonNull(role);
    }

    public static Member of(MemberId id, String firstName, String lastName, Login memberLogin, Role role) {
        return new Member(id, firstName, lastName, memberLogin, role);
    }

    public MemberId getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Login getMemberLogin() {
        return memberLogin;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", memberLogin=" + memberLogin +
                '}';
    }
}
