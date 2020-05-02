package com.library.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book implements Serializable {
	
	private static final long serialVersionUID = -5698928786951803577L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	
	private String name;
	
	private String isbn;
	
	private String review;
	
	@ManyToMany(mappedBy = "books") 
	private Set<Library> libraries = new HashSet<Library>();
	
	public void deleteLibrary(Library library) {
		library.getBooks().remove(this);
		this.libraries.remove(library);
	}

}
