package com.library.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.library.dto.LibraryDTO;
import com.library.service.LibraryService;

public class LibraryControllerTest {

	@InjectMocks
	private LibraryController libraryController;

	@Mock
	private LibraryService libraryService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		ArrayList<LibraryDTO> list = new ArrayList<LibraryDTO>();
		list.add(new LibraryDTO());
		when(libraryService.getAllLibraries()).thenReturn(list);
	}

	@Test
	public void testGetAllLibraries() {
		List<LibraryDTO> allLibraries = libraryController.getAllLibraries();
		assertTrue(allLibraries.size() == 1);
	}

}
