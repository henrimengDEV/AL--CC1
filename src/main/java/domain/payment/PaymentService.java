package domain.payment;

import domain.common.LoggerService;
import domain.event.Event;
import domain.event.EventBus;
import domain.member.Member;

public class PaymentService {

    private final LoggerService logger;
    private final EventBus<Event> eventBus;

    public PaymentService(LoggerService logger, EventBus<Event> eventBus) {
        this.logger = logger;
        this.eventBus = eventBus;
    }

    public void registeredMemberPaymentExecute(Member member) {
        this.logger.log("Registered Member payment...");
        this.eventBus.send(RegisteredMemberPaymentEvent.withMember(member));
        this.logger.log("...Successful registered for the member -> " + member);
    }
}
