package org.acme.exposition.member.response;

import org.acme.domain.member.Member;
import org.acme.domain.member.MemberLogin;
import org.acme.domain.role.Role;

public final class MemberResponse {

    public String id;
    public String firstName;
    public String lastName;
    public MemberLogin login;
    public Role role;

    private MemberResponse(String id, String firstName, String lastName, MemberLogin login, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.role = role;
    }

    public static MemberResponse of(Member member) {
        return new MemberResponse(
                member.getId().toString(),
                member.getFirstName(),
                member.getLastName(),
                member.getLogin(),
                member.getRole()
        );
    }

    @Override
    public String toString() {
        return "MemberResponse{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login=" + login +
                ", role=" + role +
                '}';
    }
}
