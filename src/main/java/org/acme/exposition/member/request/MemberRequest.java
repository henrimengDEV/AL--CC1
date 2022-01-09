package org.acme.exposition.member.request;

import org.acme.domain.member.MemberLogin;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MemberRequest {

    @NotNull
    @NotBlank
    public String firstName;

    @NotNull
    @NotBlank
    public String lastName;

    @NotNull
    public MemberLogin login;

    @NotNull
    public String roleId;

    @Override
    public String toString() {
        return "MemberRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login=" + login +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
