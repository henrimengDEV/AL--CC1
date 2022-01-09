package org.acme.application.member.command;

import org.acme.domain.member.MemberId;
import org.acme.kernel.event.DomainEvent;

public class DeleteMemberEvent implements DomainEvent {

    private final MemberId memberId;

    public DeleteMemberEvent(MemberId memberId) {
        this.memberId = memberId;
    }
}
