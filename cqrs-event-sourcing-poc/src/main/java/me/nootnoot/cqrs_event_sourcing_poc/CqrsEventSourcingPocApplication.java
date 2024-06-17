package me.nootnoot.cqrs_event_sourcing_poc;

import me.nootnoot.cqrs_event_sourcing_poc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CqrsEventSourcingPocApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(CqrsEventSourcingPocApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		orderService.createOrder("1", "ProductA");
		System.out.println("Order created!");
		System.out.println(orderService.getOrder("1"));
	}
}
