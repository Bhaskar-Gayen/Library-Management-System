package com.plazmateq.LibraryManageService.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.plazmateq.LibraryManageService.model.Credential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerClass {
	@Autowired
	private RestTemplate restTemplate;
	
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
	public String userDashboard(Credential credential) {
		//set HTTP header content 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
				
		//create new HTTP request Entity
		HttpEntity<Credential> req =new HttpEntity<>(credential,headers);
		//API call
		ResponseEntity<HttpStatus> res=restTemplate.postForEntity("http://localhost:8070/userlogin", req, HttpStatus.class);
		System.out.println(res.getBody()+" "+res.getStatusCode());
		if(res.getStatusCode()==HttpStatus.ACCEPTED)
			return "userDashboard";
				
		return "error";
	}
	
	@RequestMapping("/adminDashboard")
	public String adminDashboard(Credential credential) {
		//set HTTP header content 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//create new request HTTPEntity
		HttpEntity<Credential> req =new HttpEntity<>(credential,headers);
		ResponseEntity<HttpStatus> res=restTemplate.postForEntity("http://localhost:8070/admin", req, HttpStatus.class);
		
		if(res.getStatusCode()==HttpStatus.ACCEPTED)
			return "adminDashboard";
		return "error";
	}
	
	@RequestMapping("/bookList")
	public ResponseEntity<String> getBookList(){
		String url="http://localhost:8080/books";
		//get all book
		ResponseEntity<String> response= restTemplate.getForEntity(url, String.class);
		return response;
	}

}
