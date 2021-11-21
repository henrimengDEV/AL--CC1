package application;

import domain.member.CreateMember;
import domain.member.MemberId;
import domain.member.MemberService;

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    public MemberId createFromRequest(CreateMember createMember) {
        return this.memberService.handle(createMember);
    }
}
