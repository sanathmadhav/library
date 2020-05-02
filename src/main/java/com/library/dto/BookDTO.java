package com.library.dto;

import lombok.Data;

@Data
public class BookDTO {
	
	private Integer id;
	
	private String name;
	
	private String isbn;
	
	private String review;
	
	private Integer libraryId;
}
