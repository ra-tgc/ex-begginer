package com.example.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam06")
public class ShoppingCartController {

	private HttpSession session;
	private ServletContext application;

	@RequestMapping("")
	public String index() {
		return "item-and-cart";
	}

	@RequestMapping("in-cart")
	public String inCart() {
		return "item-and-cart";
	}

	@RequestMapping("delete")
	public String delete() {
		return "item-and-cart";
	}
}
