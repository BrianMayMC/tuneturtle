package me.nootnoot.cqrs_event_sourcing_poc.event.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventBus {
    private final EventHandler eventHandler;

    @Autowired
    public EventBus(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public void publish(OrderCreatedEvent event) {
        eventHandler.on(event);
    }
}
