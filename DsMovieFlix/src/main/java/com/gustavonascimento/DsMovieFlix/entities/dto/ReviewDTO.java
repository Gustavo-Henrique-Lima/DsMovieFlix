package com.gustavonascimento.DsMovieFlix.entities.dto;

import java.io.Serializable;

import com.gustavonascimento.DsMovieFlix.entities.Review;

import jakarta.validation.constraints.NotBlank;

public class ReviewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank
	private String text;
	private Long userId;
	private Long movieId;

	public ReviewDTO() {
	}

	public ReviewDTO(Long id, String text, Long userId, Long movieId) {
		this.id = id;
		this.text = text;
		this.userId = userId;
		this.movieId = movieId;
	}

	public ReviewDTO(Review entity) {
		this.id = entity.getId();
		this.text = entity.getText();
		this.userId = entity.getUser().getId();
		this.movieId = entity.getMovie().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

}