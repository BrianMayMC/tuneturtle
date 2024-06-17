package me.nootnoot.cqrs_event_sourcing_poc.command.handler;

import me.nootnoot.cqrs_event_sourcing_poc.event.handler.EventBus;
import me.nootnoot.cqrs_event_sourcing_poc.event.handler.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandHandler {
    private final EventBus eventBus;

    @Autowired
    public CommandHandler(EventBus eventBus){
        this.eventBus = eventBus;
    }

    public void handle(CreateOrderCommand command){
        OrderCreatedEvent event = new OrderCreatedEvent(command.getOrderId(), command.getProduct());
        eventBus.publish(event);
    }
}
