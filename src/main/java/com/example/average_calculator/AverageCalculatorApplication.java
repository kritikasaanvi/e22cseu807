package com.example.average_calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.example.average_calculator",
		"com.example.socialanalytics"
})
public class AverageCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AverageCalculatorApplication.class, args);
	}

}
