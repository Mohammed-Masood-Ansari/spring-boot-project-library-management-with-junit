package com.jsp.librarymanagementsystemspringboot.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

	@Id
	private int bookNumber;
	private String bookName;
	private String bookAuthor;
	
	@ManyToOne()
	private Student student;
	
	
}
