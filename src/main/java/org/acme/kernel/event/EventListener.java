package org.acme.kernel.event;

/**
 * @param <E> Event
 */
public interface EventListener<E extends Event> {
    void listenTo(E event);
}
