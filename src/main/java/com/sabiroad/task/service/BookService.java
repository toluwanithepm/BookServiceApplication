package com.sabiroad.task.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabiroad.task.model.Book;
import com.sabiroad.task.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> listAll() {
		return bookRepository.findAll();
	}

	public void addBook(Book book) {

		bookRepository.save(book);
	}

	public Book get(Integer id) {
		return bookRepository.findById(id).get();
	}

	public void delete(Integer id) {
		bookRepository.deleteById(id);
	}

}
