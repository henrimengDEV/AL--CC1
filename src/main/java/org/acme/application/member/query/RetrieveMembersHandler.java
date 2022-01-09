package org.acme.application.member.query;

import org.acme.domain.member.Member;
import org.acme.domain.member.Members;
import org.acme.kernel.query.QueryHandler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class RetrieveMembersHandler implements QueryHandler<RetrieveMembers, List<Member>> {

    @Inject
    private Members members;

    @Override
    public List<Member> handle(RetrieveMembers query) {
        return this.members.findAll();
    }
}
