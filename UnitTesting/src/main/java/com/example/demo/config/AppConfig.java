package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.LoanEligibility;

@Configuration
public class AppConfig {

	@Bean
	public LoanEligibility loan() {
		return new LoanEligibility();
	}
}
