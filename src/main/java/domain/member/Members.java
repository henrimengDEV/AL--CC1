package domain.member;

import kernel.Repository;

@Repository(value = "Members")
public interface Members {

    MemberId nextIdentify();

    Member findById(MemberId memberId);

    void add(Member member);
}
