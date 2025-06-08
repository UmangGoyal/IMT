package com.example.Inventory.IMT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ImtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImtApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "Spring Boot with MySQL is connected successfully!";
	}


}
