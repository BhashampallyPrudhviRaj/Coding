package com.learning.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldProjectApplication {

	public static void main(String[] args) {
		// Best for standard apps
		SpringApplication app = new SpringApplicationBuilder(HelloWorldProjectApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.build();
		app.run(args);

		// Best for dynamic bootstrapping
		// SpringApplication app = new SpringApplicationBuilder().sources(HelloWorldProjectApplication.class)
		// 		.bannerMode(Banner.Mode.OFF)
		// 		.build();
		// app.run(args);
	}

	@RequestMapping("/")
	public String home() {
		return "Home Page!";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
