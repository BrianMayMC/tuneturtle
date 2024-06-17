package me.nootnoot.cqrs_event_sourcing_poc.query.handler;

import me.nootnoot.cqrs_event_sourcing_poc.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryBus {
    private final QueryHandler queryHandler;

    @Autowired
    public QueryBus(QueryHandler queryHandler) {
        this.queryHandler = queryHandler;
    }

    public PurchaseOrder ask(GetOrderQuery query) {
        return queryHandler.handle(query);
    }
}