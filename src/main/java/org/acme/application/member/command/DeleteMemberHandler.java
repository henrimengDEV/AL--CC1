package org.acme.application.member.command;

import org.acme.domain.member.Member;
import org.acme.domain.member.Members;
import org.acme.kernel.command.CommandHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class DeleteMemberHandler implements CommandHandler<DeleteMember, List<Member>> {

    @Inject
    private Members members;

    @Override
    public List<Member> handle(DeleteMember command) {
        return members.delete(command);
//        return command.memberId;
    }
}
