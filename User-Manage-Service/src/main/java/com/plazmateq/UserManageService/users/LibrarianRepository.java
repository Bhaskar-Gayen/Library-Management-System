package com.plazmateq.UserManageService.users;

import org.springframework.data.repository.CrudRepository;

import com.plazmateq.UserManageService.model.Librarian;

public interface LibrarianRepository extends CrudRepository<Librarian, Integer> {
	Librarian findById(int id);
}
