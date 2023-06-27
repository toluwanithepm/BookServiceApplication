package com.sabiroad.task.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabiroad.task.model.Book;
import com.sabiroad.task.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	BookService bookService;

	@PostMapping("/addbook")
	public void add(@RequestBody Book book) {
		bookService.addBook(book);
	}

	@GetMapping("/books")
	public List<Book> list() {
		return bookService.listAll();
	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Book> update(@RequestBody Book book, @PathVariable Integer id) {
		try {
			Book existBook = bookService.get(id);
			existBook.setBookTitle(book.getBookTitle());
			existBook.setBookDescription(book.getBookDescription());
			existBook.setBookAuthor(book.getBookAuthor());
			existBook.setPublicationDate(book.getPublicationDate());

			bookService.addBook(existBook);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/books/{id}")
	public void delete(@PathVariable Integer id) {
		bookService.delete(id);
	}

}
