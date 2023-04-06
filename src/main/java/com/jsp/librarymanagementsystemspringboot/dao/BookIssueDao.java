package com.jsp.librarymanagementsystemspringboot.dao;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.librarymanagementsystemspringboot.dto.Book;
import com.jsp.librarymanagementsystemspringboot.dto.BookIssue;
import com.jsp.librarymanagementsystemspringboot.dto.Student;
import com.jsp.librarymanagementsystemspringboot.repository.BookIssueRepository;
import com.jsp.librarymanagementsystemspringboot.repository.BookRepository;

@Repository
public class BookIssueDao {

	@Autowired
	private BookIssueRepository bookIssueRepository;

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private BookIssue bookIssue;
	/*
	 * BookIssue Save Method
	 */
	public BookIssue saveBookIssue(int studentId, int BookId) {

		Book book = bookDao.getBookById(BookId);

		Student student = studentDao.getStudentById(studentId);

		LocalDate localDate = LocalDate.now();

		localDate = localDate.plusDays(10);

		if ((student != null) && (book != null)) {
			
			//bookIssue.setBookIssueId(BookId);
			
			bookIssue.setStudent(student);

			bookIssue.setBook(book);

			bookIssue.setBookSubmissionDate(localDate);
			
			bookIssueRepository.save(bookIssue);

			return bookIssue;
		} else {
			return null;
		}
	}
}
