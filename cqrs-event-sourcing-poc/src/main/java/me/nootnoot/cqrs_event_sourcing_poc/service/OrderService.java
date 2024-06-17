package me.nootnoot.cqrs_event_sourcing_poc.service;

import me.nootnoot.cqrs_event_sourcing_poc.command.handler.CommandBus;
import me.nootnoot.cqrs_event_sourcing_poc.command.handler.CreateOrderCommand;
import me.nootnoot.cqrs_event_sourcing_poc.model.PurchaseOrder;
import me.nootnoot.cqrs_event_sourcing_poc.query.handler.GetOrderQuery;
import me.nootnoot.cqrs_event_sourcing_poc.query.handler.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    public OrderService(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    public void createOrder(String orderId, String product) {
        CreateOrderCommand command = new CreateOrderCommand(orderId, product);
        commandBus.send(command);
    }

    public PurchaseOrder getOrder(String orderId) {
        GetOrderQuery query = new GetOrderQuery(orderId);
        return queryBus.ask(query);
    }
}