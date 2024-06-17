package me.nootnoot.cqrs_event_sourcing_poc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PurchaseOrder {
    @Id
    private String id;
    private String product;

    public PurchaseOrder() {}

    public PurchaseOrder(String id, String product) {
        this.id = id;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}