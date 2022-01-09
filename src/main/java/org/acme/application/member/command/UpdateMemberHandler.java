package org.acme.application.member.command;

import org.acme.domain.member.Member;
import org.acme.domain.member.Members;
import org.acme.kernel.command.CommandHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UpdateMemberHandler implements CommandHandler<UpdateMember, Member> {

    @Inject
    private Members members;

    @Override
    public Member handle(UpdateMember command) {
        return this.members.update(command);
    }
}
