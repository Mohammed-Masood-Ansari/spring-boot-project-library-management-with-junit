package com.jsp.librarymanagementsystemspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.librarymanagementsystemspringboot.dao.BookDao;
import com.jsp.librarymanagementsystemspringboot.dto.Book;
import com.jsp.librarymanagementsystemspringboot.dto.ResponseStructure;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class BookService {

	@Autowired
	HttpServletRequest httpServletRequest;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	BookDao bookDao;
	
	@Autowired
	ResponseStructure<Book> responseStructure;
	
	public ResponseStructure<Book> saveBook(Book book){
		
		if(httpSession.getAttribute("")!=null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Book-Added-Successfully");
			responseStructure.setData(book);
			bookDao.saveBook(book);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseStructure.setMsg("Data-Not-Added");
			responseStructure.setMsg("Please-Login-With-Librarian-Then-Add");
			responseStructure.setData(null);
			return responseStructure;
		}
	}
}
