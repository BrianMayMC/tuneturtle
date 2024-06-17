package me.nootnoot.cqrs_event_sourcing_poc.repository;

import me.nootnoot.cqrs_event_sourcing_poc.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<PurchaseOrder, String> {}