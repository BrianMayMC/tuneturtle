package me.nootnoot.cqrs_event_sourcing_poc.query.handler;

import me.nootnoot.cqrs_event_sourcing_poc.model.PurchaseOrder;
import me.nootnoot.cqrs_event_sourcing_poc.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryHandler {
    private final OrderRepository orderRepository;

    @Autowired
    public QueryHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public PurchaseOrder handle(GetOrderQuery query) {
        return orderRepository.findById(query.getOrderId()).orElse(null);
    }
}
