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
	
	@GetMapping(path="/new")
	public String newStore() {	
		return "store/new";
	}
	
	@GetMapping(path="/find")
	public String findStore() {	
		return "store/find";
	}
	
	@GetMapping(path="/append")
	public String updateStore() {	
		return "store/append";
	}
	
	@GetMapping(path="/all")
	public String getAllStores(Model model) {		
		model.addAttribute("stores", storeService.findAll());
		return "store/store";
	}
	
	@GetMapping(path="/byName")
	public String getStore(@RequestParam String name, Model model) {
		model.addAttribute("stores", storeService.findByName(name));
		return "store/store";
	}	

	@GetMapping(path="/add") 
	public String addNewStore (@RequestParam String name
			, @RequestParam String address, Model model) {

		Store s = new Store();
		s.setName(name);
		s.setAddress(address);
		storeService.save(s);
		model.addAttribute("message", "Store " + name + " saved with success!");
		return "store/new";
	}	
	
	@GetMapping(path="/update") 
	public String appendStore (@RequestParam Integer id, String name,
			@RequestParam String address, Model model) {

		Store s = new Store();
		s.setId(id);
		s.setName(name);
		s.setAddress(address);
		storeService.save(s);
		model.addAttribute("message", "Store " + name + " updated with success!");
		return "store/append";
	}
}
