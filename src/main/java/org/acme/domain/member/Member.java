package org.acme.domain.member;

import org.acme.application.member.command.CreateMember;
import org.acme.domain.role.Role;

import java.util.Objects;

public final class Member {

    private final MemberId id;
    private String firstName;
    private String lastName;
    private MemberLogin login;
    private Role role;

    private Member(MemberId id, String firstName, String lastName, MemberLogin login, Role role) {
        this.id = Objects.requireNonNull(id, "Member - given id is null");
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = Objects.requireNonNull(login, "Member - given login is null");
        this.role = Objects.requireNonNull(role);
    }

    public static Member of(MemberId id, String firstName, String lastName, MemberLogin login, Role role) {
        return new Member(id, firstName, lastName, login, role);
    }

    public static Member withCreateMember(int id, CreateMember createMember) {
        return new Member(
                MemberId.of(id),
                createMember.firstName,
                createMember.lastName,
                createMember.login,
                createMember.role);
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

    public MemberLogin getLogin() {
        return login;
    }

    public Role getRole() {
        return role;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLogin(MemberLogin login) {
        this.login = login;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Member {" +
                "\n\tid        = " + id +
                "\n\tfirstName = '" + firstName + '\'' +
                "\n\tlastName  = '" + lastName + '\'' +
                "\n\tlogin     = " + login +
                "\n\troles     = " + role +
                "\n}";
    }
}
