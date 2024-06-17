package me.nootnoot.cqrs_event_sourcing_poc.query.handler;

public class GetOrderQuery {
    private final String orderId;

    public GetOrderQuery(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
