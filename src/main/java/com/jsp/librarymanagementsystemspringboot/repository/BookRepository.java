package com.jsp.librarymanagementsystemspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.librarymanagementsystemspringboot.dto.Book;

public interface BookRepository  extends JpaRepository<Book, Integer>{

}
