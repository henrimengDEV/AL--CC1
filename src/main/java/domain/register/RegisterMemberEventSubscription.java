package domain.register;

import domain.event.Subscriber;
import domain.member.Member;
import domain.notifier.EmailNotifierEngine;
import domain.notifier.EmailNotifierEngineFactory;

public class RegisterMemberEventSubscription implements Subscriber<RegisteredMemberEvent> {

    private final EmailNotifierEngine emailNotifierEngine = EmailNotifierEngineFactory.withRegisteredEmailNotifier();

    @Override
    public void accept(RegisteredMemberEvent registeredMemberEvent) {
        Member newMember = registeredMemberEvent.getMember();
        this.emailNotifierEngine.sendSuccessEmail(newMember);
    }
}
