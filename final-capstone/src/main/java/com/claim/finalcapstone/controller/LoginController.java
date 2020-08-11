package com.claim.finalcapstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.claim.finalcapstone.model.Users;
import com.claim.finalcapstone.repository.UserRepository;
import com.claim.finalcapstone.service.UserServiceImpl;
import com.claim.finalcapstone.utils.WebUtils;
import com.claim.finalcapstone.validation.DataValidation;


@Controller
@SessionAttributes("loggedInUser")
public class LoginController {
	@Autowired
	private UserServiceImpl userService;
	
	private UserRepository userRepository;
	
	@Autowired
	WebUtils webUtils;
	
	@Autowired
	private DataValidation dataValidation;
	
	
	public LoginController(UserServiceImpl userService, UserRepository userRepository, DataValidation dataValidation) {
		super();
		this.userService = userService;
		this.userRepository = userRepository;
		this.dataValidation = dataValidation;
	}

	
	@GetMapping("profile")
	public String profile(Model model) {
		model.addAttribute("msg", "Welcome Back");
		return "profile";
	}
@GetMapping("login")
public String login(Model model) {
	model.addAttribute("msg", "Login");
	return "login";
}
@GetMapping("users")
public String users(Model model) {
	model.addAttribute("msg", "All Users");
	model.addAttribute("alldb", userService.findAll());
	return "users";
}

@PostMapping("login")
public String logIn(@RequestParam String email, @RequestParam String password, Model model) {
	//Instantiate user
	Users user = userRepository.findByEmail(email);
	if(user != null && password.equals(user.getPassword())) {
		model.addAttribute("msg", "Welcome " + user.getFname() + " " + user.getLname());
		model.addAttribute("loggedInUser", user);
		
	} else {
		model.addAttribute("error", "Invalid Credidentials");
		return "login";
	}
	return "profile";
}

@GetMapping("logout")
public String logout(Model model, WebRequest request, SessionStatus status, RedirectAttributes redirect) {
	status.setComplete();
	request.removeAttribute("loggedInUser", WebRequest.SCOPE_SESSION);
	redirect.addFlashAttribute("msg", "You have been signed out.");
	return "redirect:/login";
}
@GetMapping("register")
public String register(Model model) {
	model.addAttribute("msg", "Register");
	model.addAttribute("hidden", "");
	model.addAttribute("users", new Users());
	model.addAttribute("action", "register");
	return "register";
	}
	//Making sure the user data is correct
@PostMapping("register")
public String register(@ModelAttribute Users user, Model model, BindingResult result, RedirectAttributes redirect) {
	try {
		//checking for the user and then the result
		dataValidation.validate(user, result);
		if(result.hasErrors()) {
			model.addAttribute("error", "Required* fields");
			model.addAttribute("hidden", "");
			model.addAttribute("action", "register");
			return "register";
		}
		user.setRole("USER");
		userRepository.save(user);
		webUtils.sendMail(user.getEmail(), "Your Show Manager account has been created!", "Show Manager Account Confirmation");
		redirect.addFlashAttribute("success", ("User " + user.getFname() + " saved"));
		
	} catch (Exception e) {
	e.printStackTrace();
	}
	
	return "redirect:/users";
}
	public String editRole(RedirectAttributes model, @RequestParam long id, String role) {
		Users user = userRepository.findById(id).get();
		
		if(user !=null) {
			user.setRole(role);
			userRepository.save(user);
			model.addFlashAttribute("success", "Role Updated");
		}
			
			return "redirect:/users";
		}
	@GetMapping("delete")	
	public String deleteUser(long id, RedirectAttributes redirect) {
		userRepository.deleteById(id);
		redirect.addFlashAttribute("success", "Delete Success");
		return "redirect:/users";
	}
	//Once we have a user selected, this brings back the registration page so that
	//we can update information
	public String updateUser(@RequestParam long id, Model model) {
		userRepository.findById(id);
		model.addAttribute("msg", "Update");
		model.addAttribute("users", userRepository.findById(id));
		model.addAttribute("hidden", "hidden");
		model.addAttribute("action", "updateUser");
		return "register";
	}
	
	//Alternate Method
	
	public String update(Users user, Model model, BindingResult result) {
		dataValidation.validateUpdate(user, result);
		
		if(result.hasErrors()) {
			model.addAttribute("error", "Required fields");
			model.addAttribute("hidden", "hidden");
			model.addAttribute("action", "updateUser");
			return "register";
		}
		try {
			Users user1 = userRepository.findByEmail(user.getEmail());
			user1.setFname(user.getFname());
			user1.setLname(user.getLname());
			user1.setPhone(user.getPhone());
			userRepository.save(user1);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/users";
	}
	
	@PostMapping("search")
	//@ResponseBody
	public String search(@RequestParam String name, Model model) {
	model.addAttribute("msg", userRepository.findByName(name).size() + " Found");
	model.addAttribute("alldb", userRepository.findByName(name));

	return "users";
	}
	@ModelAttribute("user") 
	Users user() { 
		return new Users(); 
		}

}
