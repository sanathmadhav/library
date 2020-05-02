package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.LibraryDTO;
import com.library.service.LibraryService;

@RestController
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	@RequestMapping(path = "/libraries")
	public List<LibraryDTO> getAllLibraries() {
		List<LibraryDTO> libraries = libraryService.getAllLibraries();
		return libraries;
	}
}
