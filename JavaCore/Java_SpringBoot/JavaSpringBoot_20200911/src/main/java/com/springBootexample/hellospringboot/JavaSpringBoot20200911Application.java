package com.springBootexample.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.springBootexample" })
public class JavaSpringBoot20200911Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringBoot20200911Application.class, args);
	}

}
