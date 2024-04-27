package hm.sb_addresses_mvc_Homework1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hm.sb_addresses_mvc_Homework1.service.AppService;

@Controller
public class AppController {

	private AppService service;

	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	
	
	
	
	
	
	
	
	
	
}
