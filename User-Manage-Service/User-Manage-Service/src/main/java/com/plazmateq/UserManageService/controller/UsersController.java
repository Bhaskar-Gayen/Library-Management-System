package com.plazmateq.UserManageService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plazmateq.UserManageService.borrow.BorrowService;
import com.plazmateq.UserManageService.model.Admin;
import com.plazmateq.UserManageService.model.Borrow;
import com.plazmateq.UserManageService.model.User;
import com.plazmateq.UserManageService.users.AdminRepository;
import com.plazmateq.UserManageService.users.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	private AdminRepository adminRepo;
	@Autowired
	private UsersService userService;
	@Autowired
	private BorrowService borrowService;
	
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@PostMapping("/enroll")
	public void saveUser( User user) {
		userService.saveUser(user);
	}
	
	@RequestMapping("/userlogin")
	public void userAuth() {
		
	}
	
	@RequestMapping("/admin")
	public HttpStatus adminAuth(@RequestBody int id, String password) {
		Admin admin=adminRepo.findById(id);
		if(admin.getPassword().equals(password))
			return HttpStatus.OK;
		return HttpStatus.BAD_REQUEST;
	}
	
	@PostMapping("/checkin")
	public ResponseEntity<String> checkIn(@RequestBody Borrow borrow){
		System.out.println(borrow.getCheckIn());
		return borrowService.checkIn(borrow);
	}
	
	@RequestMapping("/chekout/{bookId}/{cardId}")
	public ResponseEntity<String> checkOut(@PathVariable int bookId, @PathVariable int cardId){
		return borrowService.checkOut(bookId, cardId);
	}
	
	

}
