package com.claim.finalcapstone.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.claim.finalcapstone.model.Users;
import com.claim.finalcapstone.repository.UserRepository;
import com.claim.finalcapstone.utils.WebUtils;



@Controller
@SessionAttributes("loggedInUser")
public class UploadController {
	@Autowired
	WebUtils webUtils;
	
	private UserRepository userRepository;
	
	@PostMapping("/addimages")
	public String addImages(@RequestParam("file") MultipartFile file,  @RequestParam long id, Model model) {
		
		Pattern ext = Pattern.compile("([^\\s]+(\\.(?i)(png|jpg))$)");
		
		try {
			//null is for numbers and isEmpty is for Strings
			if(file != null && file.isEmpty()) {
				model.addAttribute("error", "Error: No File Selected");
				return "redirect:profile";
			}
			if(file.getSize()>1073741824) {
				model.addAttribute("error", "File size" + file.getSize() + "KB exceed max allowed, try another photo");
				return "redirect:profile";
			}
			
			Matcher mtch = ext.matcher(file.getOriginalFilename());
			
			if(!mtch.matches()) {
				model.addAttribute("error", "Invalid Image Type");
				return "redirect:profile";
			
		} 
			
			//Save Image
			webUtils.addProfilePhoto(file,  id, "users");
			model.addAttribute("loggedInUser", userRepository.findById(id).get());
			model.addAttribute("msg", "Upload sucess" + file.getSize() + "KB");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "profile";

	}
	
	public String uploadMultipleFiles(RedirectAttributes redirect, @RequestParam long id, @ RequestParam("uploadingFiles") MultipartFile files[]) {
		
		try {
			webUtils.multipartSave(files, id);
			redirect.addFlashAttribute("sucess", "Images added size" + files.length);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:profile";
	}
	
@GetMapping("deleteimage")
	String removeImage(RedirectAttributes redirect, @RequestParam long id, @RequestParam String image, Model model) {
	

	try {
		webUtils.removeFiles(id, image);
		redirect.addFlashAttribute("success", "Image deleted");
		

		
	} catch(Exception e) {
		e.printStackTrace();
	
}
	return "redirect:profile";
}
@ModelAttribute("user")
Users user() {
	return new Users(); 	
	}


}
