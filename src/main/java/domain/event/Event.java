package domain.event;

import java.time.LocalDateTime;

public interface Event {

    EventId getId();
    LocalDateTime getEventDate();
}
