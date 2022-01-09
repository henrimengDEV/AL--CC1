package org.acme.application.member.query;

import org.acme.domain.member.MemberId;
import org.acme.kernel.query.Query;

public final class RetrieveMemberById implements Query {

    public MemberId memberId;

    public RetrieveMemberById(MemberId memberId) {
        this.memberId = memberId;
    }
}
