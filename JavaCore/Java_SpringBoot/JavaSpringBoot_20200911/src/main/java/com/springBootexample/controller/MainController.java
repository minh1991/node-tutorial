package com.springBootexample.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springBootexample.modal.employees_modal;

@Controller
public class MainController {
	public static List<employees_modal> employees_ls = Arrays.asList(new employees_modal(1, "A", 25),
			new employees_modal(2, "B", 28), new employees_modal(3, "C", 27), new employees_modal(4, "D", 30));

	@Autowired
	Environment environment;

	@GetMapping(value = "/")
	public String home(HttpServletRequest request) {
		request.setAttribute("msg", "Hello Word Spring Boot");
		return "index";
	}

	@GetMapping(value = "/employees")
	public String employees(HttpServletRequest request) {
		request.setAttribute("employees", employees_ls);
		return "employees";
	}
}
