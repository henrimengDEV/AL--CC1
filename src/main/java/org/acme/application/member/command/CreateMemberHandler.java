package org.acme.application.member.command;

import org.acme.domain.member.Member;
import org.acme.domain.member.Members;
import org.acme.domain.role.Roles;
import org.acme.kernel.command.CommandHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public final class CreateMemberHandler implements CommandHandler<CreateMember, Member> {

    public Members members;
    public Roles roles;

    @Inject
    public CreateMemberHandler(Members members, Roles roles) {
        this.members = members;
        this.roles = roles;
    }

    @Override
    public Member handle(CreateMember command) {

        return this.members.create(command);
    }
}
