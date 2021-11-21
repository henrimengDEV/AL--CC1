package domain.notifier;

import domain.common.LoggerService;
import domain.member.Member;

public class PaymentEmailNotifierEngine implements EmailNotifierEngine {

    private final LoggerService loggerService = new LoggerService();

    @Override
    public void sendSuccessEmail(Member member) {
        this.loggerService.log("Send a confirmation payment Email to the member : " + member);
    }

    @Override
    public void sendFailureEmail(Member member) {
        this.loggerService.err("Send a failure payment Email to the member : " + member);
    }
}
