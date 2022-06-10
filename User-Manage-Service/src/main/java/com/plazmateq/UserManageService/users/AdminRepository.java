package com.plazmateq.UserManageService.users;

import org.springframework.data.repository.CrudRepository;

import com.plazmateq.UserManageService.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
	Admin findById(int id);
}
