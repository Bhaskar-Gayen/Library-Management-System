package com.plazmateq.UserManageService.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plazmateq.UserManageService.model.User;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository userRepo;
	
	public List<User> getAllUsers() {
		List<User> user=new ArrayList<>();
		userRepo.findAll().forEach(u -> user.add(u));
		return user;
	}

	public User getUser(int cardId) {
		return userRepo.findById(cardId);
	}
	
	public void saveUser(User user) {
		userRepo.save(user);
	}
	
	
	public void updateUser(String id, User user) {
		userRepo.save(user);
	}
	
	
	
}
