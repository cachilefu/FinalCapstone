package com.claim.finalcapstone.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.claim.finalcapstone.model.Show;
import com.claim.finalcapstone.service.ShowService;

@Controller
public class ShowController {
	@Autowired
	private ShowService showService;
	
	
	@RequestMapping("/")
	public ModelAndView home() {
	    List<Show> listShow = showService.listAll();
	    ModelAndView mav = new ModelAndView("index");
	    mav.addObject("listShow", listShow);
	    return mav;
	}
	@RequestMapping("/new")
	public String newShowForm(Map<String, Object> model) {
		Show show = new Show();
		model.put("show", show);
		return "new_show";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveShow(@ModelAttribute("show") Show show) {
		showService.save(show);
		return "redirect:/";
	
	}
	@RequestMapping("/edit")
	public ModelAndView editShowForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_show");
		Optional<Show> customer = showService.get(id);
		mav.addObject("show", customer);
		
		return mav;
	}
	@RequestMapping("/delete")
	public String deleteShowForm(@RequestParam long id) {
		showService.delete(id);
		return "redirect:/";		
	}
//	@RequestMapping("/search")
//	public ModelAndView search(@RequestParam String keyword) {
//		List<Show> result = showService.search(keyword);
//		ModelAndView mav = new ModelAndView("search");
//		mav.addObject("result", result);
//		
//		return mav;		
//	}	
}
