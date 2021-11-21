package domain.register;

import domain.common.LoggerService;
import domain.event.Event;
import domain.event.EventBus;
import domain.member.CreateMember;
import domain.member.Member;
import domain.member.MemberId;
import domain.member.MemberService;
import domain.payment.PaymentService;

public class RegisterService {

    private final LoggerService logger;
    private final EventBus<Event> eventBus;
    private final MemberService memberService;
    private final PaymentService paymentService;

    public RegisterService(LoggerService logger, EventBus<Event> eventBus, MemberService memberService, PaymentService paymentService) {
        this.logger = logger;
        this.eventBus = eventBus;
        this.memberService = memberService;
        this.paymentService = paymentService;
    }

    public void register(CreateMember createMember) {
        this.logger.log("Registering...");

        MemberId memberId = this.memberService.handle(createMember);
        Member member = this.memberService.findById(memberId);
        this.eventBus.send(RegisteredMemberEvent.withMember(member));
        this.paymentService.registeredMemberPaymentExecute(member);

        this.logger.log("...Successful registering for the member -> " + member);
    }

}
