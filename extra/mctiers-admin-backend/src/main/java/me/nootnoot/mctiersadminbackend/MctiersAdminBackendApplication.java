package me.nootnoot.mctiersadminbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
public class MctiersAdminBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MctiersAdminBackendApplication.class, args);
	}

}
