package domain.payment;

import domain.event.Subscriber;
import domain.member.Member;
import domain.notifier.EmailNotifierEngine;
import domain.notifier.EmailNotifierEngineFactory;

public class RegisterMemberPaymentEventSubscription implements Subscriber<RegisteredMemberPaymentEvent> {

    private final EmailNotifierEngine emailNotifierEngine = EmailNotifierEngineFactory.withPaymentEmailNotifier();

    @Override
    public void accept(RegisteredMemberPaymentEvent registeredMemberPaymentEvent) {
        Member member = registeredMemberPaymentEvent.getMember();
        this.emailNotifierEngine.sendSuccessEmail(member);
    }
}
