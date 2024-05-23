package me.nootnoot.songservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
public class SongServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongServiceApplication.class, args);
	}

}
