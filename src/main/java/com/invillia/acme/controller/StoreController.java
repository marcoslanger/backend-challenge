package com.invillia.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.invillia.acme.model.entity.Store;
import com.invillia.acme.service.StoreService;

@Controller   
@RequestMapping(path="/store") 
public class StoreController {
	
	@Autowired
	private StoreService storeService;

	@GetMapping(path="/add") // Map ONLY GET Requests
	public String addNewStore (@RequestParam String name
			, @RequestParam String address) {

		Store s = new Store();
		s.setName(name);
		s.setAddress(address);
		storeService.save(s);
		return "all";
	}

	@GetMapping(path="/all")
	public String getAllUsers(Model model) {		
		model.addAttribute("stores", storeService.findAll());
		return "store";
	}
	
	@GetMapping(path="/new")
	public String newStore() {	
		return "new";
	}
}
