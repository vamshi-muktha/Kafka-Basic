package com.example.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerTrackApplication.class, args);
		System.out.println("Producer Started");
	}

}
