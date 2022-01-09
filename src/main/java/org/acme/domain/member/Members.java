package org.acme.domain.member;

import org.acme.application.member.command.CreateMember;
import org.acme.application.member.command.DeleteMember;
import org.acme.application.member.command.UpdateMember;

import java.util.List;

public interface Members {

    Member create(CreateMember createMember);

    List<Member> findAll();

    Member findById(MemberId memberId);

    List<Member> delete(DeleteMember deleteMember);

    Member update(UpdateMember command);
}
