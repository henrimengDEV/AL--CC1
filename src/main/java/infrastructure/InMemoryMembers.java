package infrastructure;

import domain.common.exception.NoSuchMemberException;
import domain.common.exception.NoSuchRoleException;
import domain.member.Member;
import domain.member.MemberId;
import domain.member.Members;
import domain.role.Role;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryMembers implements Members {

    private final AtomicInteger count = new AtomicInteger(0);
    private final Map<MemberId, Member> data = new ConcurrentHashMap<>();

    @Override
    public MemberId nextIdentify() {
        return MemberId.of(count.incrementAndGet());
    }

    @Override
    public Member findById(MemberId memberId) {
        Member member = this.data.get(memberId);

        if (member != null) {
            return member;
        } else {
            throw new NoSuchMemberException(String.format("No member found with ID %s.", memberId));
        }
    }

    @Override
    public void add(Member member) {
        this.data.put(member.getId(), member);
    }
}
