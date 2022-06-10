package com.plazmateq.LibraryManageService.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerClass {
	
	private RestTemplate restTemplate=new RestTemplate();
	
	@RequestMapping("/admin")
	public String adminLogin() {
		return "adminLogin";
	}
	
	@RequestMapping("/login")
	public String userLogin() {
		return "userLogin";
	}
	
	@RequestMapping("/register")
	public String userRegistration() {
		return "signup";
	}
	
	@RequestMapping("/userDashboard")
	public String userDashboard() {
		return "userDashboard";
	}
	
	@RequestMapping("/adminDashboard")
	public String adminDashboard() {
		return "adminDashboard";
	}
	
	@RequestMapping("/bookList")
	public ResponseEntity<String> getBookList(){
		String url="http://localhost:8080/books";
		//get all book
		ResponseEntity<String> response= restTemplate.getForEntity(url, String.class);
		return response;
	}

}
