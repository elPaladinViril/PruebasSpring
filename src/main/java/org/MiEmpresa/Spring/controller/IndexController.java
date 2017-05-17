package org.MiEmpresa.Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
	
	
	@GetMapping("/CrudEmple")
	public String indexGet(){
		return "index";
	}
	
	@PostMapping("/CrudEmple")
	public String indexPost(){
		return "index";
	}
}
