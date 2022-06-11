package com.plazmateq.UserManageService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plazmateq.UserManageService.borrow.BorrowService;
import com.plazmateq.UserManageService.model.Borrow;
import com.plazmateq.UserManageService.model.Librarian;
import com.plazmateq.UserManageService.model.User;
import com.plazmateq.UserManageService.users.LibrarianRepository;
import com.plazmateq.UserManageService.users.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	private LibrarianRepository adminRepo;
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
	public void saveUser(User user) {
		userService.saveUser(user);
	}
	
	@PostMapping("/userlogin")
	public HttpStatus userAuth(@RequestBody User user) {
		User temp=userService.getUser(user.getcard_id());
		if(temp.getPassword().equals(user.getPassword()))
			return HttpStatus.ACCEPTED;
		return HttpStatus.NOT_ACCEPTABLE;
	}
	
	@PostMapping("/admin")
	public HttpStatus adminAuthentication(@RequestBody Librarian librian) {
		Librarian admin=adminRepo.findById(librian.getId());
		if(admin.getPassword().equals(librian.getPassword()))
			return HttpStatus.ACCEPTED;
		return HttpStatus.NOT_ACCEPTABLE;
		
	}
	
	@PostMapping("/checkin")
	public ResponseEntity<String> checkIn(@RequestBody Borrow borrow ){
		System.out.println(borrow.getCheckIn());
		return borrowService.checkIn(borrow);
	}
	
	@GetMapping("/checkout/{bookId}/{cardId}")
	public ResponseEntity<String> checkOut(@PathVariable int bookId, @PathVariable int cardId){
		return borrowService.checkOut(cardId, bookId);
	}
	
	

}
