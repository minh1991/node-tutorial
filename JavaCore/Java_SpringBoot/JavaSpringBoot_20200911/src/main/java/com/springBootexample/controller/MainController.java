package com.springBootexample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@GetMapping(value = "/")
	public String home(HttpServletRequest request) {
		request.setAttribute("msg", "Hello Word Spring Boot");
		return "index";
	}
}
