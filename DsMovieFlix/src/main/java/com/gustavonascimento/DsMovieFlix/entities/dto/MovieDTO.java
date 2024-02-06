package com.gustavonascimento.DsMovieFlix.entities.dto;

import java.io.Serializable;

import com.gustavonascimento.DsMovieFlix.entities.Movie;

public class MovieDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private Integer year;
	private String subTitle;
	private String imgUrl;
	private String synopsis;
	private GenreDTO genre;

	public MovieDTO() {
	}

	public MovieDTO(Long id, String title, Integer year, String subTitle, String imgUrl, String synopsis) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.subTitle = subTitle;
		this.imgUrl = imgUrl;
		this.synopsis = synopsis;
	}

	public MovieDTO(Movie entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.year = entity.getYear();
		this.subTitle = entity.getSubTitle();
		this.imgUrl = entity.getImgUrl();
		this.synopsis = entity.getSynopsis();
	}

	public MovieDTO(Movie entity, GenreDTO genre) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.year = entity.getYear();
		this.subTitle = entity.getSubTitle();
		this.imgUrl = entity.getImgUrl();
		this.synopsis = entity.getSynopsis();
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public GenreDTO getGenre() {
		return genre;
	}

	public void setGenre(GenreDTO genre) {
		this.genre = genre;
	}

}