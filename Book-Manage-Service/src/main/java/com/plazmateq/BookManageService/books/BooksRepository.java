package com.plazmateq.BookManageService.books;

import org.springframework.data.repository.CrudRepository;

import com.plazmateq.BookManageService.model.Book;

public interface BooksRepository extends CrudRepository<Book, Integer> {
	
	Book findById(int id);
}
