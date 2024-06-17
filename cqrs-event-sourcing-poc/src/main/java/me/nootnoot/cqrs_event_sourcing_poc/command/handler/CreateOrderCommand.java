package me.nootnoot.cqrs_event_sourcing_poc.command.handler;

public class CreateOrderCommand {
    private final String orderId;
    private final String product;

    public CreateOrderCommand(String orderId, String product) {
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
