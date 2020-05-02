package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.domain.Book;
import com.library.domain.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
	
	public Book getLibraryByBooks(Integer id);

}
