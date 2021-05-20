package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.repository.MemberRepository;

@Controller
@RequestMapping("/ex05")
public class Exam05Controller {
	@Autowired
	private MemberRepository repository;

	@RequestMapping("")
	public String index() {
		return "exam05";
	}

	@RequestMapping("search-name")
	public String searchName(String name, Model model) {
		List<Member> memberList = repository.findByName(name);
		List<String> nameList = new ArrayList<>();

		for (Member member : memberList) {
			// デバッグ
			// System.out.println(member.getName());
			nameList.add(member.getName());
		}

		model.addAttribute("nameList", nameList);

		return "exam05-result";
	}
}
