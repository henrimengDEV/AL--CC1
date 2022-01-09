package org.acme.application.member.query;

import org.acme.domain.member.Member;
import org.acme.domain.member.Members;
import org.acme.kernel.query.QueryHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class RetrieveMemberByIdHandler implements QueryHandler<RetrieveMemberById, Member> {

    @Inject
    private Members members;

    @Override
    public Member handle(RetrieveMemberById query) {
        Member result = this.members.findById(query.memberId);
        if (result == null) {
            // Do something
        }

        return result;
    }
}
