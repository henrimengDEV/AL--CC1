package org.acme.application.member.command;

import org.acme.domain.member.MemberId;
import org.acme.kernel.event.DomainEvent;

public class CreateMemberEvent implements DomainEvent {

    private final MemberId memberId;

    public CreateMemberEvent(MemberId memberId) {
        this.memberId = memberId;
    }
}
