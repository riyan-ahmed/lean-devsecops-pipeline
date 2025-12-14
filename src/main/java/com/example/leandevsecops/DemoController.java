package com.example.leandevsecops;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/health")
	public String health() {
		return "OK";
	}
}