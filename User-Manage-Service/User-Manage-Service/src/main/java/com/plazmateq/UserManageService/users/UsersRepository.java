package com.plazmateq.UserManageService.users;

import org.springframework.data.repository.CrudRepository;

import com.plazmateq.UserManageService.model.User;

public interface UsersRepository extends CrudRepository<User, Integer> {
	
	User findById(int cardId);
}
