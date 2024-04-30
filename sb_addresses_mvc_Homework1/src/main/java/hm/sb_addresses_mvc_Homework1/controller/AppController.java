package hm.sb_addresses_mvc_Homework1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import hm.sb_addresses_mvc_Homework1.dto.UserDto;
import hm.sb_addresses_mvc_Homework1.service.AppService;

@Controller
public class AppController {

	private AppService service;

	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/user/{userid}")
	public String getUserById(
			Model model,
			@PathVariable("userid") String userId
			) {
		
		UserDto uDto = service.getUserById(userId);
		
		model.addAttribute("user", uDto);
		
		return "user.html";
	}
	
	
	
	
	
	
	
	
}
