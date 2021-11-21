package domain.member;


import domain.common.LoggerService;
import domain.event.Event;
import domain.event.EventBus;
import domain.register.RegisteredMemberEvent;
import domain.role.Roles;

public final class MemberService {

    private final LoggerService logger;
    private final Members members;
    private final Roles roles;

    public MemberService(LoggerService logger, Members members, Roles roles) {
        this.logger = logger;
        this.members = members;
        this.roles = roles;
    }

    public MemberId handle(CreateMember createMember) {
        this.logger.log("Handle Member...");

        final MemberId memberId = this.members.nextIdentify();
        Member member = Member.of(
                memberId,
                createMember.firstName,
                createMember.lastName,
                Login.of(createMember.login.getEmail(), createMember.login.getPassword()),
                this.roles.findByName("TRADESMAN")
        );
        this.members.add(member);

        this.logger.log("...Successful : " + member);
        return memberId;
    }

    public Member findById(MemberId id) {
        this.logger.log("Find a member by ID...");
        Member member = this.members.findById(id);
        this.logger.log("...Successful -> " + member);
        return member;
    }
}
