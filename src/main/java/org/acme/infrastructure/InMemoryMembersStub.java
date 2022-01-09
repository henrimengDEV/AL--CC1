package org.acme.infrastructure;

import org.acme.application.member.command.CreateMember;
import org.acme.application.member.command.DeleteMember;
import org.acme.application.member.command.UpdateMember;
import org.acme.domain.member.Member;
import org.acme.domain.member.MemberId;
import org.acme.domain.member.MemberLogin;
import org.acme.domain.member.Members;
import org.acme.domain.role.Role;
import org.acme.domain.role.RoleId;
import org.acme.domain.role.Roles;
import org.acme.kernel.exception.NoSuchEntityException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@ApplicationScoped
public class InMemoryMembersStub implements Members {

    private final Logger log = Logger.getLogger(InMemoryMembersStub.class.getName());
    private final AtomicInteger count = new AtomicInteger(0);
    private final Map<MemberId, Member> data = new ConcurrentHashMap<>() {{
        put(
                MemberId.of(count.incrementAndGet()),
                Member.of(MemberId.of(count.get()),
                        "NOC4r6z",
                        "bfY3",
                        MemberLogin.of("MMx1@mail.fr", "YN93YN93"),
                        Role.of(RoleId.of(1), "ADMIN"))
        );
        put(
                MemberId.of(count.incrementAndGet()),
                Member.of(MemberId.of(count.get()),
                        "5ii",
                        "cx68E0Jc",
                        MemberLogin.of("oH777t67@mail.fr", "7t8jK8t7t8jK8t"),
                        Role.of(RoleId.of(2), "TRADESMAN"))
        );
        put(
                MemberId.of(count.incrementAndGet()),
                Member.of(MemberId.of(count.get()),
                        "NvSDO5",
                        "615K",
                        MemberLogin.of("L2jptE@mail.fr", "b9Cb9Cb9Cb9C"),
                        Role.of(RoleId.of(3), "CONTRACTOR"))
        );
    }};

    @Override
    public Member create(CreateMember createMember) {
        log.info("--> create MEMBER");
        Member newMember = Member.withCreateMember(count.incrementAndGet(), createMember);

        this.data.put(newMember.getId(), newMember);
        return this.data.get(newMember.getId());
    }

    @Override
    public Member update(UpdateMember updateMember) {
        log.info("--> update MEMBER");
        Member member = this.findById(updateMember.id);
        member.setFirstName(updateMember.firstName);
        member.setLastName(updateMember.lastName);
        member.setLogin(updateMember.login);

        this.data.put(updateMember.id, member);
        return this.data.get(member.getId());
    }

    @Override
    public List<Member> findAll() {
        log.info("--> findAll MEMBERS");
        return List.copyOf(data.values());
    }

    @Override
    public Member findById(MemberId memberId) {
        log.info(String.format("--> findById(%s) MEMBER", memberId));
        Member member = this.data.get(memberId);

        if (member == null) throw NoSuchEntityException.withId(memberId.getValue());

        return member;
    }

    @Override
    public List<Member> delete(DeleteMember deleteMember) {
        log.info(String.format("--> delete(%s) MEMBER", deleteMember.memberId));
        this.data.remove(deleteMember.memberId);
        return this.findAll();
    }
}
