package com.plazmateq.BookManageService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plazmateq.BookManageService.books.BookService;
import com.plazmateq.BookManageService.model.Book;

@RestController
public class BooksController {
	
	@Autowired
	private BookService bookservice;
	
	
	@RequestMapping("/books")
	public List<Book> getAllBook() {
		return bookservice.getAllBook();
	}
	
	@RequestMapping("/books/{id}")
	public Book getBook(@PathVariable int id) {
		return bookservice.getBook(id);
	}
	
	@PostMapping("/books")
	public void saveBook(@RequestBody Book book) {
		bookservice.saveNewBook(book);
	}
	
	@PutMapping("/books/{id}")
	public void updateBook(@PathVariable int id, @RequestBody Book book) {
		bookservice.updateBookList(id, book);
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable int id) {
		bookservice.deleteBook(id);
	}
	
	@RequestMapping("books/checkout/{id}")
	public ResponseEntity<String> checkout(@PathVariable int id) {
		return bookservice.checkout(id);
	}
	
	@RequestMapping("books/checkin/{id}")
	public ResponseEntity<String> checkIn(@PathVariable int id){
		return bookservice.checkIn(id);
	}
}
