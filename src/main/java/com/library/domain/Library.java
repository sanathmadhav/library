package com.library.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Library implements Serializable {

	private static final long serialVersionUID = 6650744600812046934L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;

	private String name;

	private String address;

	@ManyToMany
	@JoinTable(name = "library_book", 
	joinColumns = @JoinColumn(name = "library_id"), 
	inverseJoinColumns = @JoinColumn(name = "book_id"))
	private Set<Book> books = new HashSet<Book>();
}