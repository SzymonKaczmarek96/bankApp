package com.example.BankApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.example.BankApp"})
@SpringBootApplication
public class BankAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class,args);
	}
}
