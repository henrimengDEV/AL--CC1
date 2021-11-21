package domain.notifier;

import domain.common.LoggerService;
import domain.member.Member;

public class RegisteredEmailNotifierEngine implements EmailNotifierEngine {

    private final LoggerService loggerService = new LoggerService();

    @Override
    public void sendSuccessEmail(Member member) {
        this.loggerService.log("Send a welcome Email to the new member : " + member);
    }

    @Override
    public void sendFailureEmail(Member member) {
        this.loggerService.err("Send a failure Email to the member : " + member);
    }
}