package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex03")
public class Exam03Controller {

	@Autowired
	private ServletContext application;

	@RequestMapping("")
	public String index() {
		return "exam03";
	}

	@RequestMapping("/receive-info")
	public String receiveInfo(String product1, String product2, String product3) {
		int sum = Integer.parseInt(product1) + Integer.parseInt(product2) + Integer.parseInt(product3);
		int sumPlusTax = (int) (sum * 1.1);

		application.setAttribute("sum", sum);
		application.setAttribute("sumPlusTax", sumPlusTax);

		return "exam03-result";

	}
}
