package com.jsp.librarymanagementsystemspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.librarymanagementsystemspringboot.dto.Librarian;
import com.jsp.librarymanagementsystemspringboot.dto.ResponseStructure;
import com.jsp.librarymanagementsystemspringboot.service.LibrarianService;

@RestController
public class LibrarianController {

	@Autowired
	LibrarianService  librarianService;
	
	@PostMapping(value = "/saveLibrarian")
	public ResponseStructure<Librarian> saveLibrarian(@RequestBody Librarian librarian) {

		return librarianService.saveLibrarian(librarian);
	}
	
	@PutMapping("/updateLibrarian/{librarianId}")
	public ResponseStructure<Librarian> updateLibrarian(@RequestBody Librarian librarian, @PathVariable int librarianId) {
		return librarianService.updateLibrarian(librarian, librarianId);
	}
}
