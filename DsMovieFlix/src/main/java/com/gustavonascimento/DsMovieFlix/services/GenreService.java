package com.gustavonascimento.DsMovieFlix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.DsMovieFlix.entities.Genre;
import com.gustavonascimento.DsMovieFlix.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository repository;

	public List<Genre> findAll() {
		return repository.findAll();
	}
}