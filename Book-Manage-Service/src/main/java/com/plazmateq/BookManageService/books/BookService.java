package com.plazmateq.BookManageService.books;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.plazmateq.BookManageService.model.Book;

@Service
public class BookService {
	
	@Autowired
	private BooksRepository bookRepo;
	
	
	public List<Book> getAllBook(){
		List<Book> bookList=new ArrayList<>();
		bookRepo.findAll().forEach(book -> bookList.add(book));
		return bookList;
	}
	
	public Book getBook(int bookId) {
		return bookRepo.findById(bookId);
	}
	
	public void saveNewBook(Book book) {
		bookRepo.save(book);
	}
	
	public void updateBookList(int bookId, Book book) {
		bookRepo.save(book);
	}
	
	public void deleteBook(int bookId) {
		bookRepo.deleteById(bookId);
	}
	
	public  ResponseEntity<String> checkout(int id) {
		Book temp= bookRepo.findById(id);
		if(temp !=null && temp.getCopy()>0) {
			temp.setCopy(temp.getCopy()-1);
			bookRepo.save(temp);
			return ResponseEntity.status(HttpStatus.CREATED).body("Successfully checkout (CODE 201)\n");
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Book Not found (CODE 417)\n");
	}

	public ResponseEntity<String> checkIn(int id) {
		Book temp= bookRepo.findById(id);
		if(temp !=null) {
			temp.setCopy(temp.getCopy()+1);
			bookRepo.save(temp);
			return ResponseEntity.status(HttpStatus.CREATED).body("Successfully CheckIn (CODE 201)\n");
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Not Found(CODE 417)\n");
	}
}
