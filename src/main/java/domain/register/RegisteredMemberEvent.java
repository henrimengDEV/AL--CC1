package domain.register;

import domain.event.Event;
import domain.event.EventId;
import domain.member.Member;

import java.time.LocalDateTime;
import java.util.Objects;

public class RegisteredMemberEvent implements Event {

    private final EventId id;
    private final LocalDateTime eventDate;
    private final Member member;

    private RegisteredMemberEvent(EventId id, LocalDateTime eventDate, Member member) {
        this.id = id;
        this.eventDate = eventDate;
        this.member = Objects.requireNonNull(member);
    }

    public static RegisteredMemberEvent withMember(Member member) {
        return new RegisteredMemberEvent(
                EventId.create(),
                LocalDateTime.now(),
                member
        );
    };

    @Override
    public EventId getId() {
        return this.id;
    }

    @Override
    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public Member getMember() {
        return member;
    }
}
