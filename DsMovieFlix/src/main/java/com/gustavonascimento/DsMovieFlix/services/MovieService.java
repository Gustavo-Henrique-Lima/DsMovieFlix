package com.gustavonascimento.DsMovieFlix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavonascimento.DsMovieFlix.entities.Movie;
import com.gustavonascimento.DsMovieFlix.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public List<Movie> findAll(){
		return repository.findAll();
	}
}