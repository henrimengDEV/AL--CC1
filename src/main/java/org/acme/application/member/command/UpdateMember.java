package org.acme.application.member.command;

import org.acme.domain.member.MemberId;
import org.acme.domain.member.MemberLogin;
import org.acme.kernel.command.Command;

public class UpdateMember implements Command {

    public MemberId id;
    public String firstName;
    public String lastName;
    public MemberLogin login;

    public UpdateMember(MemberId id, String firstName, String lastName, MemberLogin login) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
    }
}
