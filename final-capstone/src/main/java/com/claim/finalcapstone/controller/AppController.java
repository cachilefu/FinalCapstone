package com.claim.finalcapstone.controller;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestParam;

import com.claim.finalcapstone.model.Users;
import com.claim.finalcapstone.service.UserServiceImpl;
import com.claim.finalcapstone.utils.WebUtils;


	@Controller
	public class AppController {
		
		@Autowired
		private UserServiceImpl userService;
		
		@Autowired
		WebUtils webUtils;
		
		@GetMapping("index")
		public String index(Model model){
			model.addAttribute("message", "Hello There");
			model.addAttribute("all", userService.findAll());
			return "index";
		}
		
		
		//Return about
		@GetMapping("about")
		public String about(Model model) {
			model.addAttribute("about", "This is the about page");
			return "about";
		}
		
		//Return services
		@GetMapping("services")
		public String services(Model model) {
			model.addAttribute("services", "These are our services");
			return "services";
		}
		
		
		@PostMapping("sendemail")
		public String sendEmail(Model model, @RequestParam String email, @RequestParam String name, @RequestParam String subject, @RequestParam String message) {
			webUtils.sendMail(email, message, subject + " " + name);
			model.addAttribute("message", "Email Sent!");
			return "services";
		}
		public String name(@RequestParam String id, Model model) {
			index(model);
			model.addAttribute("myname", id);
			return "index";
		}
		@ModelAttribute("user")
		Users user() { 
			return new Users(); 	
			}
		
	}



