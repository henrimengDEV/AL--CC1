package org.acme.application.member.command;

import org.acme.domain.member.MemberLogin;
import org.acme.domain.role.Role;
import org.acme.kernel.command.Command;

/**
 * Command object
 */
public class CreateMember implements Command {

    public String firstName;
    public String lastName;
    public MemberLogin login;
    public Role role;

    public CreateMember(String firstName, String lastName, MemberLogin login, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.role = role;
    }

    @Override
    public String toString() {
        return "CreateMember {" +
                "\n\tfirstName='" + firstName + '\'' +
                "\n\tlastName='" + lastName + '\'' +
                "\n\tlogin=" + login +
                "\n\troles=" + role +
                "\n}";
    }
}
