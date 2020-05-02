package com.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.domain.Library;
import com.library.dto.LibraryDTO;
import com.library.repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	private LibraryRepository libraryRepository;

	public List<LibraryDTO> getAllLibraries() {
		List<LibraryDTO> libraryDTOList = new ArrayList<LibraryDTO>();
		List<Library> libraries = libraryRepository.findAll();
		if(Optional.ofNullable(libraries).isPresent()) {
			
			libraries.forEach(library -> {
				LibraryDTO libraryDTO = new LibraryDTO();
				libraryDTO.setAddress(library.getAddress());
				libraryDTO.setId(library.getId());
				libraryDTO.setName(library.getName());
				libraryDTOList.add(libraryDTO);
			});
		}
		return libraryDTOList;
	}

}
