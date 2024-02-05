package com.gustavonascimento.DsMovieFlix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.DsMovieFlix.entities.Genre;
import com.gustavonascimento.DsMovieFlix.entities.dto.GenreDTO;
import com.gustavonascimento.DsMovieFlix.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository repository;

	public List<GenreDTO> findAll() {
		List<Genre> entities = repository.findAll();
		List<GenreDTO> entitiesDto = entities.stream().map(genre->new GenreDTO(genre)).collect(Collectors.toList());
		return entitiesDto;
	}
}