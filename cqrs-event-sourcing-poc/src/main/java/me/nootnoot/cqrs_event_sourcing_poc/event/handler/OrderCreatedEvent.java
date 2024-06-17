package me.nootnoot.cqrs_event_sourcing_poc.event.handler;

public class OrderCreatedEvent {
    private final String orderId;
    private final String product;

    public OrderCreatedEvent(String orderId, String product) {
        this.orderId = orderId;
        this.product = product;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProduct() {
        return product;
    }
}
