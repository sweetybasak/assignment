package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Making the class as Controller
@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String init(Model model)
	{
		model.addAttribute("heading","Welcome to Cars24");
		return "index";
	}
}
