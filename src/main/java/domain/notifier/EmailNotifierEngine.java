package domain.notifier;

import domain.member.Member;

public interface EmailNotifierEngine {


    public void sendSuccessEmail(Member member);

    public void sendFailureEmail(Member member);
}
