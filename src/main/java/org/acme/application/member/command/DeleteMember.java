package org.acme.application.member.command;

import org.acme.domain.member.MemberId;
import org.acme.kernel.command.Command;

public class DeleteMember implements Command {

    public MemberId memberId;

    public DeleteMember(MemberId memberId) {
        this.memberId = memberId;
    }
}
