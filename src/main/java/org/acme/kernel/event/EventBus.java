package org.acme.kernel.event;

import org.acme.kernel.event.Event;
import org.acme.kernel.event.EventListener;

import java.util.List;

/**
 * @param <E> Entity
 */
public interface EventBus<E extends Event> {

    void publish(E event);

    void register(Class<? extends Event> classE, List<EventListener<? extends E>> eventListeners);
}
