package com.example.leandevsecops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Import Log4j
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class LeanDevSecOpsApplication {

	// Create a Log4j logger
	private static final Logger logger = LogManager.getLogger(LeanDevSecOpsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LeanDevSecOpsApplication.class, args);

		// Log a message to ensure Log4j is used
		logger.info("Application started with vulnerable Log4j logger!");
	}
}