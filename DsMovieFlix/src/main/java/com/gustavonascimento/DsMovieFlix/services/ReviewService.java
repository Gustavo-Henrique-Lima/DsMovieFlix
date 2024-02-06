package com.gustavonascimento.DsMovieFlix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavonascimento.DsMovieFlix.entities.Movie;
import com.gustavonascimento.DsMovieFlix.entities.Review;
import com.gustavonascimento.DsMovieFlix.entities.User;
import com.gustavonascimento.DsMovieFlix.entities.dto.ReviewDTO;
import com.gustavonascimento.DsMovieFlix.repositories.MovieRepository;
import com.gustavonascimento.DsMovieFlix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public List<ReviewDTO> findAll(){
		List<Review> entities = repository.findAll();
		List<ReviewDTO> entitiesDt = entities.stream().map(review -> new ReviewDTO(review)).collect(Collectors.toList());
		return entitiesDt;
	}
	
	@Transactional
	public ReviewDTO insert(ReviewDTO entity) {
		Review review = new Review();
		copyDtoToEntity(review, entity);
		User user=authService.authenticated();
		review.setUser(user);
		review = repository.save(review);
		return new ReviewDTO(review);
	}
	
	
	private void copyDtoToEntity(Review entity, ReviewDTO dto) {
		Movie movie=movieRepository.getReferenceById(dto.getMovieId());
		entity.setText(dto.getText());
		entity.setMovie(movie);
	}
}