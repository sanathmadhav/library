package com.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.domain.Book;
import com.library.domain.Library;
import com.library.dto.BookDTO;
import com.library.repository.BookRepository;
import com.library.repository.LibraryRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private LibraryRepository libraryRepository;

	public List<BookDTO> getAllBooks() {
		List<BookDTO> bookDTOList = new ArrayList<BookDTO>();
		List<Book> books = bookRepository.findAll();
		if (Optional.ofNullable(books).isPresent()) {
			books.forEach(book -> {
				BookDTO bookDTO = new BookDTO();
				bookDTO.setId(book.getId());
				bookDTO.setName(book.getName());
				bookDTO.setIsbn(book.getIsbn());
				bookDTO.setReview(book.getReview());
				bookDTOList.add(bookDTO);
			});
		}
		return bookDTOList;
	}

	@Transactional
	public Integer add(BookDTO bookDTO) {
		Book book = new Book();
		book.setName(bookDTO.getName());
		book.setIsbn(bookDTO.getIsbn());
		book.setReview(bookDTO.getReview());
		Book save = bookRepository.save(book);
		Optional<Library> library = libraryRepository.findById(bookDTO.getLibraryId());
		library.ifPresent(lib -> {
			book.getLibraries().add(lib);
			lib.getBooks().add(save);
			libraryRepository.flush();
		});
		return save.getId();
	}

	public void update(BookDTO bookDTO) {
		Optional<Book> book = bookRepository.findById(bookDTO.getId());
		book.ifPresent(updatedBook -> {
			updatedBook.setName(bookDTO.getName());
			updatedBook.setIsbn(bookDTO.getIsbn());
			updatedBook.setReview(bookDTO.getReview());
			bookRepository.save(updatedBook);
		});
	}

	public void delete(Integer id) {
		Optional<Book> bookOptional = bookRepository.findById(id);
		bookOptional.ifPresent(book -> {
			Set<Library> libraries = book.getLibraries();
			for (Library library : libraries) {
				library.getBooks().remove(book);
			}
			bookRepository.delete(book);
		});
	}

}
