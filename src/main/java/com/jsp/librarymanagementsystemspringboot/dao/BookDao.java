package com.jsp.librarymanagementsystemspringboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.librarymanagementsystemspringboot.dto.Book;
import com.jsp.librarymanagementsystemspringboot.repository.BookRepository;

@Repository
public class BookDao {

	@Autowired
	BookRepository bookRepository;
	
	public void saveBook(Book book) {
		
		bookRepository.save(book);
	}
}
