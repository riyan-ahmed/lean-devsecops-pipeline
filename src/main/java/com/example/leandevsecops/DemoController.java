package com.example.leandevsecops; // <-- FIXED

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/")
	public String hello() {
		return "Hello, this is the main application!";
	}
}