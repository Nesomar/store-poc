package br.com.academy.store.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class StoreManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreManagerApplication.class, args);
	}

}
