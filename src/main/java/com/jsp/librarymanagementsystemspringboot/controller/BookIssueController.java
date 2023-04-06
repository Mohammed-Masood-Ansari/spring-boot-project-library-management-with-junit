package com.jsp.librarymanagementsystemspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.librarymanagementsystemspringboot.dto.BookIssue;
import com.jsp.librarymanagementsystemspringboot.dto.ResponseStructure;
import com.jsp.librarymanagementsystemspringboot.service.BookIssueService;
import com.jsp.librarymanagementsystemspringboot.service.BookService;

@RestController
public class BookIssueController {

	@Autowired
	private BookIssueService bookIssueService;
	
	@Autowired
	private BookService bookService;
	/*
	 * update book to set student inside book
	 */
	@PostMapping(value = "/bookIssue/{studentId}/{BookId}")
	public ResponseStructure<BookIssue> updateBookWithStudentId(@PathVariable int studentId,@PathVariable int BookId) {
		
	  return bookIssueService.updateBookWithStudentId(studentId, BookId);
		
	}
}
