package com.library.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class LibraryDTO implements Serializable {
	
	private static final long serialVersionUID = -3007823247659034692L;

	private Integer id;

	private String name;

	private String address;
}
