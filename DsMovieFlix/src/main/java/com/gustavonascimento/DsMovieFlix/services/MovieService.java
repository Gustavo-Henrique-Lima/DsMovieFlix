package com.gustavonascimento.DsMovieFlix.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavonascimento.DsMovieFlix.entities.Genre;
import com.gustavonascimento.DsMovieFlix.entities.Movie;
import com.gustavonascimento.DsMovieFlix.entities.dto.GenreDTO;
import com.gustavonascimento.DsMovieFlix.entities.dto.MovieDTO;
import com.gustavonascimento.DsMovieFlix.repositories.GenreRepository;
import com.gustavonascimento.DsMovieFlix.repositories.MovieRepository;
import com.gustavonascimento.DsMovieFlix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Autowired
	private GenreRepository genreRepository;

	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Long genreId, PageRequest page) {
		List<Genre> genres = (genreId == 0) ? null : Arrays.asList(genreRepository.getReferenceById(genreId));
		Page<Movie> entities = repository.find(genres, page);
		Page<MovieDTO> entitiesDto = entities.map(movie -> new MovieDTO(movie, new GenreDTO(movie.getGenre())));
		return entitiesDto;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado"));
		return new MovieDTO(entity,new GenreDTO(entity.getGenre()));
	}
}