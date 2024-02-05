package com.gustavonascimento.DsMovieFlix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavonascimento.DsMovieFlix.entities.Review;
import com.gustavonascimento.DsMovieFlix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Transactional(readOnly = true)
	public List<Review> findAll(){
		return repository.findAll();
	}
}