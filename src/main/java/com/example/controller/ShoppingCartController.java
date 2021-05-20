package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;

@Controller
@RequestMapping("/exam06")
public class ShoppingCartController {

	private HttpSession session;
	private ServletContext application;

	@RequestMapping("")
	public String index(Model model) {
		Map<Integer, Item> itemMap = new HashMap<>();
		int sumPrice = 0;

		itemMap.put(1, new Item("手帳ノート", 1000));
		itemMap.put(2, new Item("文房具セット", 1500));
		itemMap.put(3, new Item("ファイル", 2000));

		application.setAttribute("itemMap", itemMap);

		@SuppressWarnings("unchecked")
		List<Item> itemListInCart = (List<Item>) session.getAttribute("cartItem");
		for (Item item : itemListInCart) {
			sumPrice += item.getPrice();
		}

		model.addAttribute("sumPrice", sumPrice);

		return "item-and-cart";
	}

	@RequestMapping("in-cart")
	public String inCart(Model model) {
		return index(model);
	}

	@RequestMapping("delete")
	public String delete(Model model) {
		return index(model);
	}
}
