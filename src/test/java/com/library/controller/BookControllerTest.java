package com.library.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.library.dto.BookDTO;
import com.library.service.BookService;

public class BookControllerTest {

	@InjectMocks
	private BookController bookController;

	@Mock
	private BookService bookService;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		list.add(new BookDTO());
		when(bookService.getAllBooks()).thenReturn(list);
		mockMvc = MockMvcBuilders.standaloneSetup(bookController)
                .build();
	}

	@Test
	public void testGetBooks() throws Exception {
		List<BookDTO> allBooks = bookController.getAllBooks();
		mockMvc.perform(get("/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
		assertTrue(allBooks.size() == 1);
	}

}
