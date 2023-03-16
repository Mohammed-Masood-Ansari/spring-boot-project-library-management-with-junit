package com.jsp.librarymanagementsystemspringboot.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

	@Id
	private int studentId;
	private String studentName;
	private String studentEmail;
	private long studentPhone;
	
	@OneToMany
	private List<Book> books;
	
}
