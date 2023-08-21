package com.example.plugissue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.plugissue")
//@EnableAutoConfiguration
public class PlugissueApplication {

	public static void main(String[] args) {

		SpringApplication.run(PlugissueApplication.class, args);
	}

}
