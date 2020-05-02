package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.BookDTO;
import com.library.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(path = "/books")
	public List<BookDTO> getAllBooks() {
		List<BookDTO> libraries = bookService.getAllBooks();
		return libraries;
	}
	
	@RequestMapping(path = "/books", method = RequestMethod.POST)
	public ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO) {
		bookService.add(bookDTO);
		return ResponseEntity.accepted().build();
	}
	
	@RequestMapping(path = "/books/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateBook(@PathVariable("id")Integer id, @RequestBody BookDTO bookDTO) {
		bookService.update(bookDTO);
		return ResponseEntity.accepted().build();
	}
	
	@RequestMapping(path = "/books/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBook(@PathVariable("id")Integer id) {
		bookService.delete(id);
		return ResponseEntity.accepted().build();
	}
}
