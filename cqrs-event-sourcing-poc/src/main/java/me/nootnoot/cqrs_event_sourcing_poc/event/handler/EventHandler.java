package me.nootnoot.cqrs_event_sourcing_poc.event.handler;

import me.nootnoot.cqrs_event_sourcing_poc.model.PurchaseOrder;
import me.nootnoot.cqrs_event_sourcing_poc.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventHandler {
    private final OrderRepository orderRepository;

    @Autowired
    public EventHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void on(OrderCreatedEvent event){
        PurchaseOrder purchaseOrder = new PurchaseOrder(event.getOrderId(), event.getProduct());
        orderRepository.save(purchaseOrder);
    }
}
