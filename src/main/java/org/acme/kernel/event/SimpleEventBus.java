package org.acme.kernel.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SimpleEventBus<E extends Event> implements EventBus<E> {

    private final Map<Class<? extends E>, List<EventListener<? extends E>>> associatedListeners = new HashMap<>();

    @Override
    public void publish(E event) {
        List<EventListener<? extends E>> eventListeners = this.associatedListeners.get(event.getClass());
        if (eventListeners == null) {
            //Do nothing
            return;
        }

        for (EventListener eventListener : eventListeners) {
            eventListener.listenTo(event);
        }
    }

    @Override
    public void register(Class<? extends Event> classE, List<EventListener<? extends E>> eventListeners) {
        this.associatedListeners.put((Class<? extends E>) classE, eventListeners);
    }
}
